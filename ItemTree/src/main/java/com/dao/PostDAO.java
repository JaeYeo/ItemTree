package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.PageDTO;
import com.dto.PostDTO;

@Repository
public class PostDAO {
	@Autowired
	SqlSessionTemplate template;
	
	public int postAdd(PostDTO dto) {
		System.out.println("PostDAO"+"\t"+dto);
		int postadd = template.insert("PostMapper.postAdd", dto);
		if(postadd==1) {
			System.out.println("물품등록완료");
		}
		return postadd;
	}
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) {
		System.out.println("파일업로드 dao==="+map);
		template.insert("PostMapper.insertFile", map);
	}
	
	public int selectSize() {
		int listsize = template.selectOne("PostMapper.selectSize");
		return listsize;
	}
	
	public List<PostDTO> postListAll(PageDTO pagedto){
		RowBounds row = new RowBounds(pagedto.getStartIndex(), pagedto.getPageSize());	
		System.out.println(pagedto.getStartIndex());
		System.out.println(pagedto.getPageSize());
		List<PostDTO> list = template.selectList("PostMapper.postListAll", null, row);		
		return list;
	}
	
	public PostDTO postOverview(int no) {
		PostDTO dto = template.selectOne("PostMapper.postOverview", no);
		return dto;
	}
	
	public String postfilename(int no) {
		String filename = template.selectOne("PostMapper.postfilename", no);
		return filename;
	}
	
	public int postUpdate(PostDTO dto) {
		int update = template.update("PostMapper.postUpdate", dto);
		return update;
	}
	
	public int postDelete(int no) {
		int delete = template.delete("PostMapper.postDelete", no);
		return delete;
	}
	
	public String select_userid(int no) {
		String userid = template.selectOne("PostMapper.select_userid", no);
		return userid;
	}
	
	public int post_trade_type(String type, int no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("no", no);
		int n = template.update("PostMapper.post_trade_type", map);
		return n;
	}
	
	public List<PostDTO> select_traded(String userid){
		List<PostDTO> list = template.selectList("PostMapper.select_traded", userid);
		return list;
	}
	
	public List<PostDTO> select_traded(List<Integer> nums){
		List<PostDTO> list = template.selectList("PostMapper.select_traded_buyer", nums);
		return list;
	}
	
	public List<PostDTO> search_name(String name){
		List<PostDTO> list = template.selectList("PostMapper.search_name", name);
		return list;
	}
	
	public List<PostDTO> select_myTrading(String userid){
		List<PostDTO> list = template.selectList("PostMapper.select_myTrading", userid);
		return list;
	}
	
}
