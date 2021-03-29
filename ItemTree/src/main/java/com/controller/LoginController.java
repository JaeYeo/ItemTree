package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	@Autowired MemberService service;
	
	@RequestMapping("/login" )
	public String login(@RequestParam HashMap<String, String> map, Model model, HttpSession session) {
		System.out.println(map);
		MemberDTO dto = service.login(map);
		System.out.println("loginControll"+ dto);
		String userid = map.get("userid");
		String nextPage = "";
		if(dto != null) {
			session.setAttribute("login", dto);
			nextPage = "redirect:main";
		}else if(dto == null){
			model.addAttribute("mesg", "등록된 회원이 아니거나 아이디 비빌번호가 틀렸습니다.");
			nextPage = "loginForm";
		}
		return nextPage;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
}
