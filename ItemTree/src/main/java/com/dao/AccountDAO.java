package com.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.AccountDTO;

@Repository
public class AccountDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public AccountDTO myAccount(String userid) {
		AccountDTO adto = template.selectOne("AccountMapper.myAccount", userid);
		return adto;
	}
	
	public int chargeMileage(HashMap<String, Object> map) {
		int n = template.update("AccountMapper.chargeMileage", map);
		return n;
	}
	public int tradedMileage(HashMap<String, Object> map) {
		int n = template.update("AccountMapper.tradedMileage", map);
		return n;
	}
	
	public int myMileage(String buyer) {
		System.out.println("myMileage dao=="+buyer);
		int mileage = template.selectOne("AccountMapper.myMileage", buyer);
		return mileage;
	}
	
	public int trading_Mileage(String userid, int price) {
		HashMap<String, Object> map = new HashMap<String, Object> ();
		map.put("userid", userid);
		map.put("price", price);
		int trading_Mileage = template.update("AccountMapper.trading_Mileage", map);
		return trading_Mileage;
	}
	
	public int total_buy_update(int no, int price) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("price", price);
		int total_buy_update = template.update("AccountMapper.total_buy_update", map);
		return total_buy_update;
	}
}
