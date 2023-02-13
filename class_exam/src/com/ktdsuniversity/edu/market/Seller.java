package com.ktdsuniversity.edu.market;

public class Seller extends Trader {
	public Seller(String name, int money, int stock) {
		super(name, money, stock);
	}

	public Seller(String name, int money) {
		super(name, money);
	}
	public void sell(int amount) {
		money += amount* 1000;
		stock -= amount;
	}
}
