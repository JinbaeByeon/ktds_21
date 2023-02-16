package com.ktdsuniversity.edu.class_test;

public class ProductVO {
	String name;
	int price;
	int remain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public void addRemain(int i) {
		remain += i;
	}
	
	public void addRemain() {
		++remain;
	}
}
