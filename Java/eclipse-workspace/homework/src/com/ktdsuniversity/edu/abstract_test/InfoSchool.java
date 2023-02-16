package com.ktdsuniversity.edu.abstract_test;

public class InfoSchool extends InfoPhone {
	String nameSchool;
	
	public InfoSchool(String name, String phoneNumber, String nameSchool) {
		super(name,phoneNumber);
		this.nameSchool = nameSchool;
		
	}

	public String getSchoolName() {
		return nameSchool;
	}

	public void setNameSchool(String nameSchool) {
		this.nameSchool = nameSchool;
	}
	
}
