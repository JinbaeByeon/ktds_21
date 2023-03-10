package market;

public class Market {
	public static final int PRICE_OF_APPLE = 2_000;
	private Buyer buyer = new Buyer();
	private Seller seller = new Seller();

	Market(){
		buyer.setStock(0);
		buyer.setMoney(1_000_000);
		
		seller.setStock(50);
		seller.setMoney(10_000);		
	}
	
	public void proceed() {
		buyer.buy(seller, 5);
	}

	public void show() {
		System.out.println(buyer);
		System.out.println(seller);
	}
}
