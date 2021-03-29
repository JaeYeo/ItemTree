package com.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountDAO;
import com.dto.AccountDTO;
import com.dto.MemberDTO;

@Service
public class AccountService {

	@Autowired
	AccountDAO dao;
	
	public AccountDTO myAccount(String userid) {
		AccountDTO adto = dao.myAccount(userid);
		return adto;
	}
	
	public int chargeMileage(HashMap<String, Object> map) {
		int n = dao.chargeMileage(map);
		return n;
	}
	
	public int myMileage(String buyer) {
		int mileage = dao.myMileage(buyer);
		return mileage;
	}
	
	public int trading_Mileage(String userid, int price) {
		int trading_Mileage = dao.trading_Mileage(userid, price);
		return trading_Mileage;
	}
}
