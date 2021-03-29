package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TradeDAO;
import com.dto.TradeDTO;

@Service
public class TradeService {

	@Autowired
	TradeDAO dao;
	
	public int tradeAdd(TradeDTO dto) {
		int n = dao.tradeAdd(dto);
		return n;
	}
	
	public TradeDTO getNo(String userid) {
		TradeDTO dto = dao.getNo(userid);
		return dto;
	}
	
	public void seller_apporval(boolean seller_apporval, int no) {
		dao.seller_apporval(seller_apporval, no);
	}
	
	public int trade_approval(boolean buyer_apporval, int no) {
		int approval = dao.trade_approval(buyer_apporval, no);
		return approval;
	}
	
	public List<Integer> select_no_buyer(String userid){
		List<Integer> nums = dao.select_no_buyer(userid);
		return nums;
	}
	
	
}
