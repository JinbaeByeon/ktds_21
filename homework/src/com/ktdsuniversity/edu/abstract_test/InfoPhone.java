package com.ktdsuniversity.edu.abstract_test;

public class InfoPhone {
	private String name;
	private String phoneNumber;
	
	InfoPhone(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
