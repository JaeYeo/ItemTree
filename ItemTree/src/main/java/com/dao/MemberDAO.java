package com.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;
	
	public void memberAdd(MemberDTO m) {
		System.out.println("DAO"+m);
		int n = template.insert("MemberMapper.memberAdd", m);
		int n2 = template.insert("AccountMapper.accountAdd", m);
		System.out.println("회원가입 완료:"+n+n2);
	}
	
	public int idCheck(String userid) {
		System.out.println("DAO"+userid);
		int id_Check = template.selectOne("MemberMapper.idCheck", userid);
		return id_Check;
	}
	
	public MemberDTO login(HashMap<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.login", map);
		return dto;
	}
	
	public int memberUpdate(MemberDTO dto) {
		System.out.println(dto);
		int memberUpdate = template.update("MemberMapper.memberUpdate", dto);
		return memberUpdate;
	}
	
	public int memberPWUpdate(HashMap<String, String> map) {
		int memberPWUpdate = template.update("MemberMapper.memberPWUpdate", map);
		return memberPWUpdate;
	}
	
	public int memberDelete(HashMap<String, String> map) {
		int memberDelete = template.delete("MemberMapper.memberDelete", map);
		return memberDelete;
	}
	
	public MemberDTO selectM(String userid) {
		MemberDTO dto = template.selectOne("MemberMapper.selectM", userid);
		return dto;
	}
}
