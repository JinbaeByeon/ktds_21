package com.ktdsuniversity.edu.market;

public class Buyer extends Trader {
	public Buyer(String name, int money) {
		super(name, money);
	}

	public Buyer(String name, int money, int stock) {
		super(name, money, stock);
	}

	public void buy(Seller seller, int amount) {
		money -= amount * 1000;
		stock += amount;
		seller.sell(amount);		
	}
}
