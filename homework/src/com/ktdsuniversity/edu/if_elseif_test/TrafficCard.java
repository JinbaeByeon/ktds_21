package com.ktdsuniversity.edu.if_elseif_test;

public class TrafficCard {
	private boolean isAdult;
	private int money;

	public boolean isAdult() {
		return isAdult;
	}

	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void pay() {
		int money = 0;
		if (isAdult) {
			System.out.println("성인입니다.");
			money = 1300;
		} else {
			System.out.println("청소년입니다.");
			money = 900;
		}

		if (this.money >= money) {
			this.money -= money;
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
}
