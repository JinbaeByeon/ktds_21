package com.ktdsuniversity.edu.constructor;

public class Doctor {

	private String computer;
	private String tool;

	public Doctor(String computer,String tool) {
		this.computer = computer;
		this.tool = tool;
	}
	public String examination() {
		return "의사가 " + computer +"와 " + tool +"으로 진찰합니다.";
	}

	
}
