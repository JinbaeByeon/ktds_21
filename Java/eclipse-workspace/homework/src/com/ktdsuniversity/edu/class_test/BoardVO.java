package com.ktdsuniversity.edu.class_test;

public class BoardVO {
	private String title;
	private String writer;
	private String time;
	private int views;
	private int number;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		String res = "제목: " + title + " (작성자: "  + writer + ") - " + time
					+ "\n조회수: " + views + "[글번호: " + number + "]";  
		return res;
	}
}
