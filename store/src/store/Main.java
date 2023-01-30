package store;

public class Main {
	Store store = new Store();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.store.addProducts();
		main.store.checkProducts();
	}

}
