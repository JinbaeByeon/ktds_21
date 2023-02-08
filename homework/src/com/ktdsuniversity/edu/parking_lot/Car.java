package com.ktdsuniversity.edu.parking_lot;

public class Car {
	CarType type;
	int number;
	long time;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
