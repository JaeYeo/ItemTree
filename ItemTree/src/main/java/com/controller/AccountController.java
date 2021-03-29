package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AccountDTO;
import com.dto.MemberDTO;
import com.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService service;
	
	@RequestMapping("/myAccount")
	public ModelAndView myAccount(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		String userid = mdto.getUserid();
		AccountDTO adto = service.myAccount(userid);
		System.out.println(adto);
		
		mav.addObject("myAccount", adto);
		mav.setViewName("myAccount");
		return mav;
	}
	
	@RequestMapping("/mCharging")
	public String mCharging() {
		return "mCharging";
	}
	
	@RequestMapping("/paymethods")
	public ModelAndView paymethods(@RequestParam("method") String m) {
		ModelAndView mav = new ModelAndView();
		String paymethod = "account/paymethods.jsp";	
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kakaopay", "account/kakaopay.jsp");
		map.put("naverpay", "account/naverpay.jsp");
		System.out.println("paymethods key"+m);
		System.out.println("paymethods val"+map.get(m));
		
		paymethod = map.get(m);
		mav.addObject("paymethod", paymethod);
		mav.setViewName("mCharging");
		return mav;
	}
}
