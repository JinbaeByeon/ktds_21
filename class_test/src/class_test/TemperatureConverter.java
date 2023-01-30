package class_test;

public class TemperatureConverter {
	/**
	 * 섭씨를 화씨로 변경
	 * 
	 * @param cel : int
	 * @return double
	 */
	public double toFah(int cel) {
		double fah = cel * 1.8 + 32;
		System.out.println("섭씨 " + cel + " -> 화씨 " + fah);
		return fah;
	}

	/**
	 * 화씨를 섭씨로 변경
	 * 
	 * @param fah : double
	 * @return int
	 */
	public int toCel(double fah) {
		int cel =(int) ((fah - 32) / 1.8);
		System.out.println("화씨 " + fah + " -> 섭씨 " + cel);
		return cel;
	}
}
