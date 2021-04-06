package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dao.PostDAO;
import com.dto.PageDTO;
import com.dto.PostDTO;
import com.util.FileUtils;

@Service
public class PostService {
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Autowired
	PostDAO dao;
	
	public int postAdd(PostDTO dto, MultipartHttpServletRequest mpRequest) throws Exception {
		int postadd = dao.postAdd(dto);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(dto, mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			System.out.println("파일정보==="+list.get(i));
			dao.insertFile(list.get(i));
		}
		return postadd;
	}
	
	public int selectSize() {
		int listsize = dao.selectSize();
		return listsize;
	}
	
	public List<PostDTO> postListAll(PageDTO pagedto){
		List<PostDTO> list = dao.postListAll(pagedto);
		return list;
	}
	
	public PostDTO postOverview(int no) {
		PostDTO dto = dao.postOverview(no);
		return dto;
	}
	
	public String postfilename(int no) {
		String filename = dao.postfilename(no);
		return filename;
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
	
	public List<PostDTO> search_name(String name){
		List<PostDTO> list = dao.search_name(name);
		return list;
	}
	
	public List<PostDTO> select_myTrading(String userid){
		List<PostDTO> list = dao.select_myTrading(userid);
		return list;
	}
}
