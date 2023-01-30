package gas_station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GasStation {
	public static List<Double> PRICE_OF_OIL = new ArrayList<>();

	private List<Fuel> fuels = new ArrayList<>();

	private int money;

	private void init() {
		PRICE_OF_OIL.add(Fuel.GASOLINE, 1569.67);
		PRICE_OF_OIL.add(Fuel.DIESEL, 1651.15);
		PRICE_OF_OIL.add(Fuel.LPG, 1039.35);
		PRICE_OF_OIL = Collections.unmodifiableList(PRICE_OF_OIL);

		fuels.add(new Fuel(Fuel.GASOLINE, 6000));
		fuels.add(new Fuel(Fuel.DIESEL, 1000));
		fuels.add(new Fuel(Fuel.LPG, 500));

		setMoney(5_000_000);
	}

	public GasStation() {
		init();
	}

	public Fuel getFuel(int type) {
		return fuels.get(type);
	}

	public void setFuels(int type, Fuel fuel) {
		fuels.add(type, fuel);
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
	public boolean sell(int type, int amount) {
		boolean res = false;

		if (checkRemain(type, amount)) {
			fuels.get(type).subtract(amount);
			res = true;
		} else {
			System.out.println("기름 잔량이 부족합니다.");
		}

		return res;
	}

	/**
	 * type의 연료를 amount만큼 주유가능한지 확인
	 * 
	 * @param type   연료의 종류(GASOLINE, DIESEL, LPG)
	 * @param amount 연료의 양
	 * @return
	 */
	private boolean checkRemain(int type, int amount) {
		boolean res = false;

		if (fuels.get(type).getRemain() >= amount) {
			res = true;
		}
		return res;
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
