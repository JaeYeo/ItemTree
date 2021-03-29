package com.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.MemberDTO;
import com.service.AccountService;

//by jungwoo 20201207
@Controller
public class PayController {
	@Autowired
	private AccountService service;
	
	@RequestMapping("/kakaoPay_ready")
	public String kakaoPay_ready(@RequestParam("pay") int pay, HttpSession session) throws ServletException, IOException {						
		//받아온 값중 결제정보에 넣을 값 파싱
		String cid = "TC0ONETIME"; //고정값
		String partner_order_id = "partner_order_id"; //고정값
		String partner_user_id = "partner_user_id"; //고정값
		
		String query = "cid=" + cid;
		query += "&partner_order_id=" + partner_order_id;
		query += "&partner_user_id=" + partner_user_id;
		query += "&item_name=" + "ItemTree 마일리지 충전"; //상품이름
		query += "&item_code=" + "qpqpqpqpqpqp"; //상품코드
		query += "&quantity=" + "1"; //상품수량 passengerNum
		query += "&total_amount=" + pay; //전체 결제금액
		query += "&vat_amount=" + "0"; //부가세 금액
		query += "&tax_free_amount=" + "0"; //비과세 금액
		query += "&approval_url=" + "http://localhost:8090/ItemTree/kakaopay_approval";  //결제 완료시 요청할 url, Kakaopay_approval.java로 이동
		query += "&fail_url=" + "http://localhost:8090/"; //결제 실패시 요청할 url
		query += "&cancel_url=" + "http://localhost:8090/"; //결제 취소시 요청할 url
		System.out.println(query);
		String getTID = getHttpConnection("https://kapi.kakao.com/v1/payment/ready", query); //아래getHttpConnection메소드에 넘겨주기 POST요청
		System.out.println("getTID=="+getTID);
		
		JSONObject jObject = new JSONObject(getTID); //응답받은 값은 JSON객체이므로 형변환
		String tid = jObject.getString("tid"); //JSON객체에서 tid값만 뽑아오기
		String redirect = jObject.getString("next_redirect_pc_url"); //JSON객체에서 next_redirect_url뽑아오기
		
		session.setAttribute("tid", tid);
		session.setAttribute("cid", cid);
		session.setAttribute("partner_order_id", partner_order_id);
		session.setAttribute("partner_user_id", partner_user_id);
		return "redirect:"+redirect;
	}
	private String getHttpConnection(String uri, String param) throws ServletException, IOException {
//		System.out.println("uri=="+uri); //API url주소
//		System.out.println("pram=="+param); //API에 넘겨줄 데이터 
		URL url = new URL(uri); //API주소 URL로 변환
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection(); //URL로 Connection하기
		conn.setRequestMethod("POST"); //데이터 넘기는 방식 POST로 설정
		
		String Authorization = "KakaoAK d12c0a4013abd55cffd0f76c8925b0c2"; //API사용하는 key값
		String type = "application/x-www-form-urlencoded;charset=UTF-8"; //API사용하는 데이터형식
		conn.setRequestProperty("Authorization", Authorization); //HEAD에 따로 담아야 함.
		conn.setRequestProperty("Content-type", type); //HEAD에 따로 담아야 함.
		conn.setDoOutput(true);
		conn.setDoInput(true);
		try (OutputStream stream = conn.getOutputStream()) {
			try (BufferedWriter wd = new BufferedWriter(new OutputStreamWriter(stream))) {
				wd.write(param);
			}
		}
		int responseCode = conn.getResponseCode(); // 서버 응답코드, 200이면 성공
		String line;
		StringBuffer buffer = new StringBuffer();
		String TID = "";
		try (InputStream stream = conn.getInputStream()) {
			try (BufferedReader rd = new BufferedReader(new InputStreamReader(stream))) {
				while ((line = rd.readLine()) != null) {
					buffer.append(line);
					buffer.append('\r');
					TID += line + "\r"; // 응답받은 값을 String으로 받아옴
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return TID; //응답받아온 String형태의 값 리턴
	}
	
	//결제가 이뤄지고 난뒤
	@RequestMapping(value = "/kakaopay_approval")
	public ModelAndView Kakaopay_approval(@RequestParam("pg_token") String pg_token, HttpSession session) throws ServletException, IOException {
		String cid = (String)session.getAttribute("cid");
		String tid = (String)session.getAttribute("tid");
		String partner_order_id = (String)session.getAttribute("partner_order_id");
		String partner_user_id = (String)session.getAttribute("partner_user_id");
		//String payload = "aaaaaaaaaaaaa";//결제 승인 요청에 대해 저장하고 싶은 값,
		System.out.println("approval=cid="+cid);
		System.out.println("approval=tid="+tid);
		System.out.println("approval=pg_token="+pg_token);
		String query = "cid=" + cid;
		query += "&tid=" + tid;
		query += "&partner_order_id=" + partner_order_id;
		query += "&partner_user_id=" + partner_user_id;
		query += "&pg_token=" + pg_token;	
		//카카오페이 api승인 요청, 요청값 approval에 파싱
		System.out.println("approval==="+query);
		String approval = getHttpConnection("https://kapi.kakao.com/v1/payment/approve", query); //POST요청
		
		//승인값(approval) 데이터 가공
		JSONObject jObject = new JSONObject(approval);
		String aid = jObject.getString("aid");
		String payment_method_type = jObject.getString("payment_method_type");
		JSONObject amount = jObject.getJSONObject("amount");
			int total = amount.getInt("total");
//			int tax_free = amount.getInt("tax_free");
//			int vat = amount.getInt("vat");
//			int point = amount.getInt("point");
//			int discount = amount.getInt("discount");
//		String item_name = jObject.getString("item_name");
//		String item_code = jObject.getString("item_code");
//		int quantity = jObject.getInt("quantity");
//		String created_at = jObject.getString("created_at");
//		String approved_at = jObject.getString("approved_at");
		
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		String userid = mdto.getUserid();
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("userid"+userid+"mileage"+total);
		map.put("userid", userid);
		map.put("mileage", total);
		//결제가 끝나면 DB접근해서 마일리지 충전
		int n = updateMileage(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("success", "충전 실패. 잠시 후 다시 시도해주세요.");
		if(n==1) {
			mav.addObject("success", "마일리지가 충전되었습니다.");		
		}
		mav.setViewName("mCharging");

		return mav;
	}
	
	
	public int updateMileage(HashMap<String, Object> map) {		
		int n = service.chargeMileage(map);
		return n;
	}
	
//	public String makeReservation(HttpSession session) {
//		//결제가 완료되면 결제상태가 true
//		String payState = "TRUE";
//		
//		ReservationDTO reservationDTO = (ReservationDTO) session.getAttribute("reservationDTO");
//		//결제 시점에 시간을 이용하여 ID가 생성되고 가져온다
//		String reservation_Date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
//		String reservation_ID = reservationService.getReservation_Id(reservation_Date);
//		
//		reservationDTO.setReservation_ID(reservation_ID);
//		reservationDTO.setReservation_Date(reservation_Date);
//		reservationDTO.setPayState(payState);
//		
//		int n = reservationService.updateReservation(reservationDTO);
//		
//		String nextPage = "main";
//		if(n==1) {
//			session.setAttribute("reservationDTO", reservationDTO);
//			System.out.println(reservationDTO);
//			nextPage = "reservationComplete";
//		} 
//		
//		return nextPage;
//	}
	
	
}
