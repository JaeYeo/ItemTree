package com.dto;

public class PostDTO {
	String userid;
	int No;
	String type;
	String gamename;
	String servername;
	String category;
	int amount;
	int price;
	String title;
	String content;
	String charactername;
	String regdate;
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDTO(String userid, int no, String type, String gamename, String servername, String category, int amount,
			int price, String title, String content, String charactername, String regdate) {
		super();
		this.userid = userid;
		No = no;
		this.type = type;
		this.gamename = gamename;
		this.servername = servername;
		this.category = category;
		this.amount = amount;
		this.price = price;
		this.title = title;
		this.content = content;
		this.charactername = charactername;
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "PostDTO [userid=" + userid + ", No=" + No + ", type=" + type + ", gamename=" + gamename
				+ ", servername=" + servername + ", category=" + category + ", amount=" + amount + ", price=" + price
				+ ", title=" + title + ", content=" + content + ", charactername=" + charactername + ", regdate="
				+ regdate + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCharactername() {
		return charactername;
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
