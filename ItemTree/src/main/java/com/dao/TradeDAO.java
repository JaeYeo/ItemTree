package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.TradeDTO;

@Repository
public class TradeDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public int tradeAdd(TradeDTO dto) {
		int n = template.insert("TradeMapper.tradeAdd", dto);
		return n;
	}
	
	public TradeDTO getNo(String userid) {
		TradeDTO dto = template.selectOne("TradeMapper.getNo", userid);
		return dto;
	}
	
	public void seller_apporval(boolean seller_apporval, int no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("approval", seller_apporval);
		map.put("no", no);
		template.update("TradeMapper.seller_apporval", map);
	}
	
	public int trade_approval(boolean buyer_apporval, int no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("approval", buyer_apporval);
		map.put("no", no);
		int approval = template.update("TradeMapper.trade_approval", map);
		
		return approval;
	}
	
	public List<Integer> select_no_buyer(String userid){
		List<Integer> nums = template.selectList("TradeMapper.select_no_buyer", userid);
		return nums;
	}
}
