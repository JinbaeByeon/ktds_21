package com.ktdsuniversity.edu.market;

public class Main {
	final static public int a = 0;

	public static void main(String[] args) {
		Buyer buyer = new Buyer("구매자", 5_000_000);
		Seller seller = new Seller("구매자", 5_000_000, 10);

		buyer.buy(seller, 5);
	}
}
