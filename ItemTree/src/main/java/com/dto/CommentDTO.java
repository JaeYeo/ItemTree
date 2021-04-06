package com.dto;

public class CommentDTO {
	
	int commentno;
	int no;
	String userid;
	String content;
	String regdate;
	
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(int commentno, int no, String userid, String content, String regdate) {
		super();
		this.commentno = commentno;
		this.no = no;
		this.userid = userid;
		this.content = content;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentno=" + commentno + ", no=" + no + ", userid=" + userid + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}

	public int getCommentno() {
		return commentno;
	}

	public void setCommentno(int commentno) {
		this.commentno = commentno;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
