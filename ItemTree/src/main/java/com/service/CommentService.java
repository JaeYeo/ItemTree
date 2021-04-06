package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommentDAO;
import com.dto.CommentDTO;

@Service
public class CommentService {

	@Autowired
	CommentDAO dao;
	
	public void comment_add(CommentDTO dto) {
		dao.comment_add(dto);
	}
	
	public List<CommentDTO> comment_list(int no){
		List<CommentDTO> list = dao.comment_list(no);
		return list;
	}
	
	public void comment_del(int no) {
		dao.comment_del(no);
	}
}
