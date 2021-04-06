package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.PageDTO;
import com.dto.PostDTO;
import com.service.PostService;

@Controller
public class MainController {
	@Autowired
	PostService service;
	
	@RequestMapping({"/", "/main", "/postList"})
	public ModelAndView main(@RequestParam(defaultValue="1") int curPage) {
		System.out.println("maincontroller");
		ModelAndView mav = new ModelAndView();
		
		
		//전체 리스트 갯수
		int listCnt = service.selectSize();
		PageDTO pagedto = new PageDTO(listCnt, curPage);
		List<PostDTO> list = service.postListAll(pagedto);
		
		mav.addObject("pagedto", pagedto);
		mav.addObject("List", list);
		mav.setViewName("main");
		return mav;
	}
	//1.5 : 회원가입, 물품등록, 물품보기, 물품상세보기, 물품수정
	//2.0 : 물품수정 및 삭제
	//2.5 : 마이페이지 - 회원정보 수정, 비밀번호 변경, 회원탈퇴, 내계좌보기, 글자깨짐(web.xml에 filter추가)
	//3.0 : 마일리지충전, 물품거래
	//3.5 : 물품상세보기에서 다이렉트메세지, 물품거래 버그수정.
	//4.0 : 물품등록시 이미지첨부, 거래중인 물품에서 쪽지함.
	//4.5 : 쿠폰발급, 쿠폰사용
	
}
