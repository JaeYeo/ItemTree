package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.CommentDTO;
import com.dto.MemberDTO;
import com.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService service;
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String comment_add(CommentDTO comm_dto, HttpSession session) {
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		comm_dto.setUserid(mdto.getUserid());
		System.out.println("댓글==="+comm_dto);
		//댓글 추가
		if(!comm_dto.getContent().equals("")) {
			service.comment_add(comm_dto);
		}
		
		List<CommentDTO> list = service.comment_list(comm_dto.getNo());		
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();//JSON배열 선언
		for (int i = 0; i < list.size(); i++) {
			JSONObject jObject = new JSONObject();//JSON배열에 들어갈 JSON
			jObject.put("no", list.get(i).getCommentno());
			jObject.put("userid", list.get(i).getUserid());
			jObject.put("content", list.get(i).getContent());
			jObject.put("regdate", list.get(i).getRegdate());
			arr.put(jObject);
		}
		obj.put("no", comm_dto.getNo());
		obj.put("item", arr);
		
		System.out.println("리스트==="+list);		
		
		
		System.out.println("JSON==="+obj);
		return obj.toString();
	}
	
	@RequestMapping(value = "/loginCheck/comment_del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String comment_del(int no) {
		String mesg = "삭제완료";
		service.comment_del(no);
		return mesg;
	}
}
