package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CommentDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService service;
	
	@RequestMapping("/loginCheck/postForm")
	public String postForm() {
		return "redirect:../postForm";
		//#########  interceptor 주의  ##########
		//return "../";  // ../ 을 이용하여 /loginCheck의 상위 주소로 이동하여 주소를 사용함
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/loginCheck/postAdd")
	public String postAdd(PostDTO dto, MultipartHttpServletRequest mpRequest) throws Exception {
		System.out.println("postAdd"+"\t"+dto);
		service.postAdd(dto, mpRequest);
		return "redirect:../main";
	}
	
	@RequestMapping("postOverview")
	public ModelAndView postOverview(@RequestParam("no") int no) {
		System.out.println(no);
		ModelAndView mav = new ModelAndView();
		PostDTO dto = service.postOverview(no);
		String filename = service.postfilename(no);
		System.out.println(dto);
		mav.addObject("dto", dto);
		mav.addObject("imgname", filename);
		
		
		mav.setViewName("postOverview");
		
		return mav;
	}
	
	@RequestMapping("postScreenshot")
	public ModelAndView postScreenshot(String imgname) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("imgname", imgname);
		System.out.println(imgname);
		mav.setViewName("postScreenshot");
		
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
	
	@RequestMapping("/search_name")
	public ModelAndView search_name(@RequestParam("search_name") String name) {
		ModelAndView mav = new ModelAndView();
		List<PostDTO> list = service.search_name(name);
		mav.addObject("List", list);
		mav.setViewName("main");
		return mav;
	}
	

}
