package com.dto;

public class TradeDTO {
	String buyer_id;
	String seller_id;
	String buyer_charname;
	int no;
	boolean buyer_approval;
	boolean seller_approval;
	int seller_code;
	int buyer_code;
	boolean buyer_cancel;
	boolean seller_cancel;
	public TradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TradeDTO(String buyer_id, String seller_id, String buyer_charname, int no, boolean buyer_approval,
			boolean seller_approval, int seller_code, int buyer_code, boolean buyer_cancel, boolean seller_cancel) {
		super();
		this.buyer_id = buyer_id;
		this.seller_id = seller_id;
		this.buyer_charname = buyer_charname;
		this.no = no;
		this.buyer_approval = buyer_approval;
		this.seller_approval = seller_approval;
		this.seller_code = seller_code;
		this.buyer_code = buyer_code;
		this.buyer_cancel = buyer_cancel;
		this.seller_cancel = seller_cancel;
	}
	@Override
	public String toString() {
		return "TradeDTO [buyer_id=" + buyer_id + ", seller_id=" + seller_id + ", buyer_charname=" + buyer_charname
				+ ", no=" + no + ", buyer_approval=" + buyer_approval + ", seller_approval=" + seller_approval
				+ ", seller_code=" + seller_code + ", buyer_code=" + buyer_code + ", buyer_cancel=" + buyer_cancel
				+ ", seller_cancel=" + seller_cancel + "]";
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getBuyer_charname() {
		return buyer_charname;
	}
	public void setBuyer_charname(String buyer_charname) {
		this.buyer_charname = buyer_charname;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public boolean isBuyer_approval() {
		return buyer_approval;
	}
	public void setBuyer_approval(boolean buyer_approval) {
		this.buyer_approval = buyer_approval;
	}
	public boolean isSeller_approval() {
		return seller_approval;
	}
	public void setSeller_approval(boolean seller_approval) {
		this.seller_approval = seller_approval;
	}
	public int getSeller_code() {
		return seller_code;
	}
	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}
	public int getBuyer_code() {
		return buyer_code;
	}
	public void setBuyer_code(int buyer_code) {
		this.buyer_code = buyer_code;
	}
	public boolean isBuyer_cancel() {
		return buyer_cancel;
	}
	public void setBuyer_cancel(boolean buyer_cancel) {
		this.buyer_cancel = buyer_cancel;
	}
	public boolean isSeller_cancel() {
		return seller_cancel;
	}
	public void setSeller_cancel(boolean seller_cancel) {
		this.seller_cancel = seller_cancel;
	}
	
	
	
	
}
