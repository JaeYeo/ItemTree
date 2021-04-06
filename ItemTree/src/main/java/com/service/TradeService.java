package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TradeDAO;
import com.dto.BuyingDTO;
import com.dto.SellingDTO;
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
	
	public void seller_cancel(boolean seller_cancel, int no) {
		dao.seller_cancel(seller_cancel, no);
	}
	public void buyer_cancel(boolean buyer_cancel, int no) {
		dao.buyer_cancel(buyer_cancel, no);
	}
	
	public int trade_approval(boolean buyer_apporval, int no) {
		int approval = dao.trade_approval(buyer_apporval, no);
		return approval;
	}
	public int seller_approval(boolean seller_apporval, int no) {
		int approval = dao.seller_approval(seller_apporval, no);
		return approval;
	}
	
	public List<Integer> select_no_buyer(String userid){
		List<Integer> nums = dao.select_no_buyer(userid);
		return nums;
	}
	
	public List<SellingDTO> selling_list(String userid){
		List<SellingDTO> list = dao.selling_list(userid);
		return list;
	}
	
	public List<BuyingDTO> buying_list(String userid){
		List<BuyingDTO> list = dao.buying_list(userid);
		return list;
	}
	
	public TradeDTO select_no(int no) {
		TradeDTO dto = dao.select_no(no);
		return dto;
	}
	
	
}
