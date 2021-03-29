package com.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public void memberAdd(MemberDTO m) {
		System.out.println("service"+m);
		dao.memberAdd(m);
	}
	
	public int idCheck(String userid) {
		System.out.println("service"+userid);
		int id_Check = dao.idCheck(userid);
		return id_Check;
	}
	
	public MemberDTO login(HashMap<String, String> map) {
		MemberDTO dto = dao.login(map);
		return dto;
	}
	
	public int memberUpdate(MemberDTO dto) {
		int memberUpdate = dao.memberUpdate(dto);
		return memberUpdate;
	}
	
	public int memberPWUpdate(HashMap<String, String> map) {
		int memberPWUpdate = dao.memberPWUpdate(map);
		return memberPWUpdate;
	}
	
	public int memberDelete(HashMap<String, String> map) {
		int memberDelete = dao.memberDelete(map);
		return memberDelete;
	}
	
	public MemberDTO selectM(String userid) {
		MemberDTO dto = dao.selectM(userid);
		return dto;
	}
}
