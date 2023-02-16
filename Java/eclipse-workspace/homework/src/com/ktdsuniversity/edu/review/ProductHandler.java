package com.ktdsuniversity.edu.review;

import java.util.ArrayList;
import java.util.List;

public class ProductHandler {
	private List<Product> listProducts;
	private int money;

	public ProductHandler() {
		listProducts = new ArrayList<>();
		listProducts.add(new Product("a", 1000));
		listProducts.add(new Product("a", 1000));
		listProducts.add(new Product("a", 1000));
		listProducts.add(new Product("b", 2000));
		listProducts.add(new Product("b", 2000));
		listProducts.add(new Product("b", 2000));
		listProducts.add(new Product("c", 3000));
		listProducts.add(new Product("c", 3000));
		listProducts.add(new Product("c", 3000));
		money = 1_000_000;
	}

	public int removeOne(String name) {
		int price = 0;
		for (Product p : listProducts) {
			if (p.getName().equals(name)) {
				price = p.getPrice();
				listProducts.remove(p);
				break;
			}
		}
		return price;
	}

	public void order(String name) {
		money += removeOne(name);
	}

	public void orderAll() {
		while (true) {
			if (listProducts.size() == 0) {
				break;
			}
			order(listProducts.get(0).getName());
		}
	}

	public void addProduct(Product product) {
		listProducts.add(product);
	}

	public void addProduct(Product product, int cnt) {
		for(int i=0;i<cnt;++i) {
			addProduct(product);
		}
	}

	@Override
	public String toString() {
		String res = "";
		for(Product p : listProducts) {
			res += p.getName() + " | " + p.getPrice() + "\n";
		}
		return res;
	}
}
