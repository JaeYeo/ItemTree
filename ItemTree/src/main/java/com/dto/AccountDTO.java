package com.dto;

public class AccountDTO {
	String userid;
	int mileage;
	int sum_sell;
	int sum_buy;
	boolean coupon1;
	boolean coupon2;
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(String userid, int mileage, int sum_sell, int sum_buy, boolean coupon1, boolean coupon2) {
		super();
		this.userid = userid;
		this.mileage = mileage;
		this.sum_sell = sum_sell;
		this.sum_buy = sum_buy;
		this.coupon1 = coupon1;
		this.coupon2 = coupon2;
	}
	@Override
	public String toString() {
		return "AccountDTO [userid=" + userid + ", mileage=" + mileage + ", sum_sell=" + sum_sell + ", sum_buy="
				+ sum_buy + ", coupon1=" + coupon1 + ", coupon2=" + coupon2 + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getSum_sell() {
		return sum_sell;
	}
	public void setSum_sell(int sum_sell) {
		this.sum_sell = sum_sell;
	}
	public int getSum_buy() {
		return sum_buy;
	}
	public void setSum_buy(int sum_buy) {
		this.sum_buy = sum_buy;
	}
	public boolean isCoupon1() {
		return coupon1;
	}
	public void setCoupon1(boolean coupon1) {
		this.coupon1 = coupon1;
	}
	public boolean isCoupon2() {
		return coupon2;
	}
	public void setCoupon2(boolean coupon2) {
		this.coupon2 = coupon2;
	}
	
	
}
