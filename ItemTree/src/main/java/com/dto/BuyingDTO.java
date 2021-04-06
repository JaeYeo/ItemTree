package com.dto;

public class BuyingDTO {

	int no;
	String userid;
	String type;
	String category;
	String title;
	int amount;
	int price;
	String seller_id;
	String charactername;
	int buyer_code;
	int seller_code;
	
	public BuyingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyingDTO(int no, String userid, String type, String category, String title, int amount, int price,
			String seller_id, String charactername, int buyer_code, int seller_code) {
		super();
		this.no = no;
		this.userid = userid;
		this.type = type;
		this.category = category;
		this.title = title;
		this.amount = amount;
		this.price = price;
		this.seller_id = seller_id;
		this.charactername = charactername;
		this.buyer_code = buyer_code;
		this.seller_code = seller_code;
	}
	@Override
	public String toString() {
		return "BuyingDTO [no=" + no + ", userid=" + userid + ", type=" + type + ", category=" + category + ", title="
				+ title + ", amount=" + amount + ", price=" + price + ", seller_id=" + seller_id + ", charactername="
				+ charactername + ", buyer_code=" + buyer_code + ", seller_code=" + seller_code + "]";
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
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getCharactername() {
		return charactername;
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
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
