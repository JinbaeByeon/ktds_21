package gas_station;

public class Customer {
	private Fuel fuel;
	private int money;

	public Customer(Fuel fuel, int money) {
		this.fuel = fuel;
		this.money = money;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	/**
	 * 구매 (gasStation에게 type의 Fuel을 amount만큼 구매)
	 * 
	 * @param gasStation 주유소
	 * @param type       연료의 종류(GASOLINE, DIESEL, LPG)
	 * @param amount     연료의 양
	 */
	public void buy(GasStation gasStation, FuelType type, int amount) {
		double price = amount * GasStation.PRICES.get(type);
		
		if (!checkMoney(price)) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		if (gasStation.sell(type, amount)) {
			fuel.add(amount);
			pay(gasStation, price);
		}
	}

	/**
	 * 금액 지불 (gasStation에게 price만큼 돈 지불)
	 * 
	 * @param gasStation 주유소
	 * @param price      구매 금액
	 */
	private void pay(GasStation gasStation, double price) {
		money -= price;
		gasStation.income(price);
	}
	/**
	 * price만큼 지불 가능한지 확인
	 * 
	 * @param price 구매 금액
	 * @return
	 */
	private boolean checkMoney(double price) {
		return money >= price;
	}

	@Override
	public String toString() {
		return "[고객] " + fuel + "/ 자본금: " + money;
	}

}
