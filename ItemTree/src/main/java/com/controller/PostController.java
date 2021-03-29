package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.PostDTO;
import com.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService service;
	
	@RequestMapping("/postAdd")
	public String postAdd(PostDTO dto) {
		System.out.println("postAdd"+"\t"+dto);
		service.postAdd(dto);
		return "redirect:main";
	}
	
	@RequestMapping("postOverview")
	public ModelAndView postOverview(@RequestParam("no") int no) {
		System.out.println(no);
		ModelAndView mav = new ModelAndView();
		PostDTO dto = service.postOverview(no);
		System.out.println(dto);
		mav.addObject("dto", dto);
		mav.setViewName("postOverview");
		
		return mav;
	}
	
	@RequestMapping("/postUpdate")
	public ModelAndView postUpdate(@RequestParam("no") int no) {
		System.out.println(no);
		ModelAndView mav = new ModelAndView();
		PostDTO dto = service.postOverview(no);
		System.out.println(dto);
		mav.addObject("dto", dto);
		mav.setViewName("postUpdate");		
		return mav;
	}
	
	@RequestMapping("/postUpdate2")
	public ModelAndView postUpdate2(PostDTO dto) {
		System.out.println(dto);
		ModelAndView mav = new ModelAndView();
		service.postUpdate(dto);
		PostDTO pdto = service.postOverview(dto.getNo());
		
		mav.addObject("dto", pdto);
		mav.setViewName("postOverview");		
		return mav;
	}
	
	@RequestMapping("/postDelete")
	public String postDelete(@RequestParam("no") int no, Model model) {
		int delete = service.postDelete(no);
		model.addAttribute("mesg", "물품 삭제 성공");
		return "redirect:main";
	}
}
