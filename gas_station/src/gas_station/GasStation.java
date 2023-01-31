package gas_station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GasStation {
	public static final Map<FuelType, Double> PRICES;

	static {
		PRICES = new HashMap<>();
		PRICES.put(FuelType.GASOLINE, 1569.67);
		PRICES.put(FuelType.DIESEL, 1651.15);
		PRICES.put(FuelType.LPG, 1039.35);

//		PRICE_OF_OIL = Collections.unmodifiableList(PRICE_OF_OIL);
	}
	
	private List<Fuel> fuels;
	private int money;

	private void init() {
		if (fuels.isEmpty()) {
			fuels.add(new Fuel(FuelType.GASOLINE, 5_000));
			fuels.add(new Fuel(FuelType.DIESEL, 3_000));
			fuels.add(new Fuel(FuelType.LPG, 1_000));
		}

		setMoney(1_000_000);
	}

	public GasStation() {
		fuels = new ArrayList<>();
		init();
	}

	public Fuel getFuel(int type) {
		return fuels.get(type);
	}

	public void setFuels(int type, Fuel fuel) {
		fuels.set(type, fuel);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void income(double money) {
		this.money += money;
	}

	/**
	 * 판매 (type 연료를 amount 만큼 판매)
	 * 
	 * @param type   연료의 종류(GASOLINE, DIESEL, LPG)
	 * @param amount 연료의 양
	 * @return
	 */
	public boolean sell(FuelType type, int amount) {
		if (checkRemain(type, amount)) {
			fuels.get(type.ordinal()).subtract(amount);
			return true;
		} else {
			System.out.println("기름 잔량이 부족합니다.");
			return false;
		}
	}

	/**
	 * type의 연료를 amount만큼 주유가능한지 확인
	 * 
	 * @param type   연료의 종류(GASOLINE, DIESEL, LPG)
	 * @param amount 연료의 양
	 * @return
	 */
	private boolean checkRemain(FuelType type, int amount) {
		return fuels.get(type.ordinal()).getRemain() >= amount;
	}

	@Override
	public String toString() {
		String res = "[주유소]\n";
		for (Fuel fuel : fuels) {
			res += fuel + "\n";
		}
		res += "자본금: " + money;
		return res;

	}
}
