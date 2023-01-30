package lotto;

public class Lotto {

	public static void main(String[] args) {
		int[] lottoArray = new int[6];
		lottoArray[0] = 5;
		lottoArray[1] = 15;
		lottoArray[2] = 27;
		lottoArray[3] = 34;
		lottoArray[4] = 36;
		lottoArray[5] = 41;
		
		// 전통적인 for
		for (int i = 0; i < lottoArray.length; ++i) {
			System.out.println(lottoArray[i]);						
		}
		
		// 성능이 빠른 foreach
		for (int i : lottoArray) {
			System.out.println(i);
		}
	}
}
