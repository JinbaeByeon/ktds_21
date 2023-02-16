package com.ktdsuniversity.edu.market;

public abstract class Trader {
	protected String name;
	protected int money;
	protected int stock;

	protected Trader(String name, int money, int stock) {
		this.name = name;
		this.money = money;
		this.stock = stock;
	}

	protected Trader(String name, int money) {
		this.name = name;
		this.money = money;
	}
}
