package com.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public List<PostDTO> postListAll(){
		List<PostDTO> list = template.selectList("PostMapper.postListAll");
		return list;
	}
	
	public PostDTO postOverview(int no) {
		PostDTO dto = template.selectOne("PostMapper.postOverview", no);
		return dto;
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
	
}
