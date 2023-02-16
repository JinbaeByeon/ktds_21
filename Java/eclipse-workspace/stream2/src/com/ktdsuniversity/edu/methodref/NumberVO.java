package com.ktdsuniversity.edu.methodref;

public class NumberVO {

	private int number;

	public NumberVO(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean isEven() {
		return this.number % 2 == 0;
	}
	
}
