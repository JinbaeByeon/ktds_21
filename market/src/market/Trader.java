package market;

public class Trader {
	protected int money;
	protected int stock;
	
	Trader()
	{
		
	}
	Trader(int money, int stock){
		this.money = money;
		this.stock = stock;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

	@Override
	public String toString() {
		return "사과 재고: " + stock + "개, 자본금: " + money + "원";
	}
	
}
