package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/memberAdd", produces = "text/plain;charset=UTF-8")
	public ModelAndView memberAdd(MemberDTO m, ModelAndView mav) {
		System.out.println("controll"+m);
		service.memberAdd(m);
		mav.addObject("mesg", "회원가입 성공");
		mav.setViewName("redirect:main");
		return mav;
	}
	
	@RequestMapping(value = "/idDuplicateCheck" ,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String idDuplicateCheck(String userid) {
		System.out.println("memberidcheck"+"\t"+userid);
		int id_check = service.idCheck(userid);
		System.out.println("id_check"+"\t"+id_check);
		String mesg= "아이디 사용 가능";
		if(id_check==1) {
			mesg = "아이디 중복";
		}
		return mesg;
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "mypage";
		if(dto==null) {
			nextPage = "loginForm";
		}		
		return nextPage;
	}
	
	@RequestMapping("/memberUpdate")
	public String memberUpdate(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "memberUpdate";
		if(dto==null) {
			nextPage = "loginForm";
		}		
		return nextPage;
	}
	
	@RequestMapping("/memberUpdate2")
	public String memberUpdate2(MemberDTO dto, Model model, HttpSession session) {
		System.out.println("memberUpdate2"+ dto);
		int memberUpdate2 = service.memberUpdate(dto);
		System.out.println(memberUpdate2);
		
		session.invalidate();
		return "redirect:main";
	}
	
	@RequestMapping("/memberPWUpdate")
	public String memberPWUpdate(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "memberPWUpdate";
		if(dto==null) {
			nextPage = "loginForm";
		}		
		return nextPage;
	}
	
	@RequestMapping("/memberPWUpdate2")
	public String memberPWUpdate2(@RequestParam HashMap<String, String> map, Model model, HttpSession session) {
		System.out.println(map.get("userid"));
		System.out.println(map.get("passwd3"));
		int memberPWUpdate = service.memberPWUpdate(map);		
		session.invalidate();
		return "redirect:main";
		
	}
	@RequestMapping("/memberDelete")
	public String memberDelete(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = "memberDelete";
		if(dto==null) {
			nextPage = "loginForm";
		}		
		return nextPage;
	}
	
	@RequestMapping("/memberDelete2")
	public String memberdelete2(@RequestParam HashMap<String, String> map, Model model, HttpSession session) {
		System.out.println(map.get("userid"));
		System.out.println(map.get("passwd"));
		int memberDelete = service.memberDelete(map);		
		session.invalidate();
		model.addAttribute("mesg", "회원탈퇴 성공");
		return "redirect:main";
		
	}
}
