package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public void comment_add(CommentDTO dto) {
		template.insert("CommentMapper.comment_add", dto);
	}
	
	public List<CommentDTO> comment_list(int no){
		List<CommentDTO> list = template.selectList("CommentMapper.comment_list", no);
		return list;
	}
	
	public void comment_del(int no) {
		template.delete("CommentMapper.comment_del", no);
	}
}
