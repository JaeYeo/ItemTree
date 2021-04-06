package com.dto;

public class SellingDTO {

	int no;
	String userid;
	String type;
	String category;
	String title;
	int amount;
	int price;
	String buyer_id;
	String buyer_charname;
	int buyer_code;
	int seller_code;
	public SellingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellingDTO(int no, String userid, String type, String category, String title, int amount, int price,
			String buyer_id, String buyer_charname, int buyer_code, int seller_code) {
		super();
		this.no = no;
		this.userid = userid;
		this.type = type;
		this.category = category;
		this.title = title;
		this.amount = amount;
		this.price = price;
		this.buyer_id = buyer_id;
		this.buyer_charname = buyer_charname;
		this.buyer_code = buyer_code;
		this.seller_code = seller_code;
	}
	@Override
	public String toString() {
		return "SellingDTO [no=" + no + ", userid=" + userid + ", type=" + type + ", category=" + category + ", title="
				+ title + ", amount=" + amount + ", price=" + price + ", buyer_id=" + buyer_id + ", buyer_charname="
				+ buyer_charname + ", buyer_code=" + buyer_code + ", seller_code=" + seller_code + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getBuyer_charname() {
		return buyer_charname;
	}
	public void setBuyer_charname(String buyer_charname) {
		this.buyer_charname = buyer_charname;
	}
	public int getBuyer_code() {
		return buyer_code;
	}
	public void setBuyer_code(int buyer_code) {
		this.buyer_code = buyer_code;
	}
	public int getSeller_code() {
		return seller_code;
	}
	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}
	
	
	
}
