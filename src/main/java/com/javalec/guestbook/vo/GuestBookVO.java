package com.javalec.guestbook.vo;

public class GuestBookVO {
	private int no;
	private String name;
	private String content;
	private String password;
	private String regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPw() {
		return password;
	}
	public void setPw(String pw) {
		this.password = pw;
	}
	public String getDate() {
		return regdate;
	}
	public void setDate(String date) {
		this.regdate = date;
	}
	
	@Override
	public String toString() {
		return "GuestVO [no=" + no + ", name=" + name + ", content=" + content + ", pw=" + password + ", date=" + regdate
				+ "]";
	}

}
