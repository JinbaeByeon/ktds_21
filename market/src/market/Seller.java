package market;

/**
 * 판매자
 * 
 * @author User
 *
 */
public class Seller extends Trader {
	/**
	 * 판매
	 * (buyer에게 amount만큼 판매)
	 * @param amount 주문개수
	 */
	public void sell(int amount) {
		stock-=amount;	
	}
	public void addMoney(int money) {
		this.money += money;
	}
	@Override
	public String toString() {
		return "[판매자] " + super.toString();
	}
}
