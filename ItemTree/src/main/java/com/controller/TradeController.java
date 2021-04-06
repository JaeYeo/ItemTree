package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AccountDTO;
import com.dto.BuyingDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.dto.SellingDTO;
import com.dto.TradeDTO;
import com.mysql.cj.log.Log;
import com.service.AccountService;
import com.service.MemberService;
import com.service.PostService;
import com.service.TradeService;

@Controller
public class TradeController {
	
	@Autowired
	PostService pservice;
	@Autowired
	AccountService aservice;
	@Autowired
	MemberService mservice;
	@Autowired
	TradeService tservice;
	
	@RequestMapping("/tradeForm")
	public ModelAndView trade(@RequestParam("no") int no, @RequestParam("buyer") String buyer) {
		ModelAndView mav = new ModelAndView();
		System.out.println("tradeForm=="+no+"\t"+buyer);
		PostDTO dto = pservice.postOverview(no);
		
//		AccountDTO adto = aservice.myAccount(buyer);
//		int mileage = adto.getMileage();
		System.out.println("서비스전=="+buyer);
		int mileage = aservice.myMileage(buyer);
		
		System.out.println(mileage);
		mav.addObject("dto", dto);
		mav.addObject("myMileage", mileage);
		mav.setViewName("tradeForm");
		return mav;
	}
	
	@RequestMapping("/trading")
	public ModelAndView trading(@RequestParam("no") int no,@RequestParam("BCname") String bcname, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//구매자정보 판매자정보 물품정보
		MemberDTO buyer_dto = (MemberDTO)session.getAttribute("login");
		String buyer_id = buyer_dto.getUserid();
		String seller_id = pservice.select_userid(no); 
		MemberDTO seller_dto = mservice.selectM(seller_id);
		PostDTO pdto = pservice.postOverview(no);
		TradeDTO tdto = new TradeDTO(buyer_id, seller_id, bcname, no, false, false, (int)(Math.random()*10000), (int)(Math.random()*10000), false, false);
		//결제했으니 구매자 돈뺴기
		int price = pdto.getPrice();
		System.out.println("차감 전"+aservice.myMileage(buyer_id));
		int trading_Mileage = aservice.trading_Mileage(buyer_id, price);
		System.out.println("차감 후"+aservice.myMileage(buyer_id));
		
		//결제했으니 물품은 거래중으로, trade DB에 새로 추가
		int n =pservice.post_trade_type("거래중", no);
		int n2 = tservice.tradeAdd(tdto);
		String nextPage = "tradeForm";
		if(trading_Mileage!=0) {
			nextPage = "tradingForm";
			mav.addObject("buyer_dto", buyer_dto);
			mav.addObject("seller_dto", seller_dto);
			mav.addObject("pdto", pdto);
			mav.addObject("tdto", tdto);
		}
		mav.setViewName(nextPage);
		return mav;
	}
	@RequestMapping("/trading2")
	public ModelAndView trading(@RequestParam("no") int no, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		//구매자정보 판매자정보 물품정보
		PostDTO pdto = pservice.postOverview(no);
		TradeDTO tdto = tservice.select_no(no);
		MemberDTO buyer_dto = mservice.selectM(tdto.getBuyer_id());
		MemberDTO seller_dto = mservice.selectM(tdto.getSeller_id());
		mav.addObject("buyer_dto", buyer_dto);
		mav.addObject("seller_dto", seller_dto);
		mav.addObject("pdto", pdto);
		mav.addObject("tdto", tdto);
		mav.setViewName("tradingForm");
		return mav;
	}
	
	@RequestMapping("/myTrading")
	public ModelAndView myTrading(HttpSession session, @RequestParam("type") String type) {
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		String nextPage = "main";
		if(type.equals("selling")) {
			//판매중이면 sellingDTO
			List<SellingDTO> selling_list = tservice.selling_list(userid);
			mav.addObject("List", selling_list);
			nextPage = "sellingList";
		}else if(type.equals("buying")) {
			//구매중이면 buyingDTO
			List<BuyingDTO> buying_list = tservice.buying_list(userid);
			mav.addObject("List", buying_list);
			nextPage = "buyingList";
		}
		mav.setViewName(nextPage);
		return mav;
	}
	
	@RequestMapping(value = "/seller_approval", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String seller_approval(boolean seller_approval, int no) {
		
		String mesg = "물품전달 완료를 해주세요.";
		System.out.println("판매자 승인=="+seller_approval);
		System.out.println("물품번호-==="+no);
		if(seller_approval == true) {
			tservice.seller_approval(seller_approval, no);
			mesg = "물품전달 완료";
		}
		return mesg;
	}
	
	@RequestMapping("/trade_approval")
	public ModelAndView trade_approval(boolean buyer_approval, int no) {
		System.out.println("구매자 확정==="+buyer_approval);
		System.out.println("물품번호====="+no);
		ModelAndView mav = new ModelAndView();
		String nextPage = "main";
		int approval = 0;
		PostDTO pdto = pservice.postOverview(no);
		String seller = pdto.getUserid();
		
		int price = pdto.getPrice();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userid", seller); //판매자 아이디
		map.put("mileage", price); //물품 가격
		//구매자 확정시 trade DB의 구매자승인 업데이트
		if(buyer_approval == true) {
			approval =tservice.trade_approval(buyer_approval, no);
		}//구매자승인이 이루어지면 물품(Post DB)은 거래완료 업데이트, 판매자(Member DB)에게 마일리지 입금
		//판매자 총 판매금액, 구매자 총 구매금액 업데이트
		if(approval == 1) {
			pservice.post_trade_type("거래완료", no);
			aservice.tradedMileage(map); // 판매자 마일리지입금, 판매금액 업데이트
			aservice.total_buy_update(no, price); //구매자 구매금액 업데이트
			pdto = pservice.postOverview(no);
			mav.addObject("dto", pdto);
			nextPage = "tradedOverview";
		}
		mav.setViewName(nextPage);
		return mav;
		
	}
	
	@RequestMapping("/tradedList")
	public ModelAndView traded(@RequestParam("user") String user, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println("traded====="+user);
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		String userid = mdto.getUserid();
		String nextPage = "main";
		System.out.println("true?==="+user=="buyer");
		if(user.equals("seller")) {
			//판매자의 경우 글목록에서 판매자아이디로 거래완료 물품리스트 가져오기
			List<PostDTO> seller_traded_list = pservice.select_traded(userid);
			mav.addObject("List", seller_traded_list);
			mav.addObject("type", "판매완료");
			nextPage = "tradedList";
		}else if(user.equals("buyer")) {
			//구매자의 경우 구매자id로 tradeDB에서 글 번호들을 가져와서 그 중 거래완료 리스트 가져오기
			List<Integer> nums = tservice.select_no_buyer(userid);
			System.out.println("nums===="+nums);
			List<PostDTO> buyer_traded_list = pservice.select_traded(nums);
			System.out.println("list===="+buyer_traded_list);
			mav.addObject("List", buyer_traded_list);
			mav.addObject("type", "구매완료");
			nextPage = "tradedList";
		}
		mav.setViewName(nextPage);
		return mav;
	}
	
	@RequestMapping("/tradedOverview")
	public ModelAndView postOverview(@RequestParam("no") int no) {
		System.out.println(no);
		ModelAndView mav = new ModelAndView();
		PostDTO dto = pservice.postOverview(no);
		System.out.println(dto);
		mav.addObject("dto", dto);
		mav.setViewName("tradedOverview");
		
		return mav;
	}
	
	@RequestMapping("/trade_cancel")
	public String trade_cancel(boolean buyer_cancel, boolean seller_cancel, int no) {
		System.out.println("구매자취소=="+buyer_cancel);
		System.out.println("판매자취소=="+seller_cancel);
		System.out.println("물품번호=="+no);
		//취소요청마다 승인 업데이트
		if(buyer_cancel) {
			tservice.buyer_cancel(buyer_cancel, no);
		}else if(seller_cancel) {
			tservice.seller_cancel(seller_cancel, no);
		}
		//물품번호로 거래취소 조회해서 둘다 승인하면 거래취소와 환불
		TradeDTO tdto = tservice.select_no(no);		
		if(tdto.isBuyer_cancel() && tdto.isSeller_cancel()) {			
			//구매자아이디 금액 찾아서 마일리지 환불
			String buyer_id = tdto.getBuyer_id();
			PostDTO pdto = pservice.postOverview(no);
			int price = pdto.getPrice();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userid", buyer_id);
			map.put("mileage", price);
			aservice.chargeMileage(map);
			pservice.postDelete(no);
		}
		
		return "redirect:main";
	}
}
