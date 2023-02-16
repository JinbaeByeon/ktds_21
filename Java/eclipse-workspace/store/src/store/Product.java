package store;

public class Product {
	private String name;
	private int quantity;

	Product(String n, int q) {
		name = n;
		quantity = q;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int q) {
		quantity += q;
	}

	public String getName() {
		return name;
	}
}
