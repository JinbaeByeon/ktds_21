package market;

/**
 * 구매자
 * 
 * @author User
 *
 */
public class Buyer extends Trader {
	/**
	 * 주문 (seller에게 amount 만큼 주문)
	 * 
	 * @param seller 판매자
	 * @param amount 주문개수
	 * @param price  단가
	 */
	public void buy(Seller seller, int amount) {
		int price = amount * Market.PRICE_OF_APPLE;

		if(money < price) {
			System.out.println("돈없음");
			return;
			
		}
		if (seller.getStock() < amount) {
			System.out.println("재고없음");
			return;
		}

		stock += amount;
		seller.sell(amount);
		pay(seller,price);
	}

	/**
	 * 지불 (seller에게 price 만큼 지불)
	 * 
	 * @param seller 판매자
	 * @param price 가격
	 */
	private void pay(Seller seller, int price) {
		money -= price;
		seller.addMoney(price);
	}

	@Override
	public String toString() {
		return "[구매자] " + super.toString();
	}
}
