package store;

import java.util.ArrayList;
import java.util.List;

public class Store {
	List<Product> products = new ArrayList<Product>();
	ProductCounter productCounter = new ProductCounter();
	
	public void addProducts(){
		addProduct("water", 0);
		addProduct("drink", 1);
		addProduct("snack", 2);
		addProduct("snack", 3);
	}
	public void checkProducts() {
		productCounter.checkQuantity(products);
	}
	
	public void addProduct(String name,int quantity) {
		for(Product p : products) {
			if(p.getName().equals(name)) {
				p.addQuantity(quantity);
				return;
			}
		}
		products.add(new Product(name,quantity));
	}

}
