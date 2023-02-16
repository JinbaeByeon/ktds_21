package hello_java;

public class Method {
	/**
	 * 섭씨를 화씨로 변경
	 * 
	 * @param cel : int
	 * @return double
	 */
	public static double toFah(int cel) {
		double fah = cel * 1.8 + 32;
		System.out.println(cel + " -> " + fah);
		return fah;
	}

	/**
	 * 화씨를 섭씨로 변경
	 * 
	 * @param fah : double
	 * @return int
	 */
	public static int toCel(double fah) {
		int cel =(int) ((fah - 32) / 1.8);
		System.out.println(fah + " -> " + cel);
		return cel;
	}

	/**
	 * 4과목의 평균을 계산
	 * 
	 */
	public static void getAvg() {
		// 4가지 과목의 점수
		int scoreA = 65;
		int scoreB = 56;
		int scoreC = 78;
		int scoreD = 82;
		int sum = scoreA + scoreB + scoreC + scoreD;
		
		/*
		 * 4가지 과목의 평균을 구해 avg에 넣기
		 */
		double avg = sum / 4.;

		System.out.println("Average: " + avg);
	}
	
	public static void main(String[] args) {
		System.out.println("시작");
		// 섭씨
		int cel = 38;
		// 화씨
		double fah = toFah(cel);
		cel = toCel(fah);

		getAvg();
		System.out.println("끝");
	}
}
