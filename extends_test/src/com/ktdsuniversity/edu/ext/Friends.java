package com.ktdsuniversity.edu.ext;

public class Friends extends Address {
	private String birthDate;

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDay) {
		this.birthDate = birthDay;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return "친구 주소: " + super.getAddress();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "친구 이름: " + super.getName();
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return "친구 번호: " + super.getPhoneNumber();
	}

	@Override
	public String toString() {
		return super.toString() + "\n생년월일: " + birthDate;
	}

}
