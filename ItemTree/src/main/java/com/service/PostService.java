package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PostDAO;
import com.dto.PostDTO;

@Service
public class PostService {
	@Autowired
	PostDAO dao;
	
	public int postAdd(PostDTO dto) {
		int postadd = dao.postAdd(dto);
		return postadd;
	}
	
	public List<PostDTO> postListAll(){
		List<PostDTO> list = dao.postListAll();
		return list;
	}
	
	public PostDTO postOverview(int no) {
		PostDTO dto = dao.postOverview(no);
		return dto;
	}
	
	public int postUpdate(PostDTO dto) {
		int update = dao.postUpdate(dto);
		return update;
	}
	
	public int postDelete(int no) {
		int delete = dao.postDelete(no);
		return delete;
	}
	
	public String select_userid(int no) {
		String userid = dao.select_userid(no);
		return userid;
	}
	
	public int post_trade_type(String type, int no) {
		int n = dao.post_trade_type(type, no);
		return n ;
	}
	
	public List<PostDTO> select_traded(String userid){
		List<PostDTO> list = dao.select_traded(userid);
		return list;
	}
	
	public List<PostDTO> select_traded(List<Integer> nums){
		List<PostDTO> list = dao.select_traded(nums);
		return list;
	}
}
