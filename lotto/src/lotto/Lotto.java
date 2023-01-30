package lotto;

public class Lotto {

	public static void main(String[] args) {
//		int[] lottoArray = new int[6];
//		lottoArray[0] = 5;
//		lottoArray[1] = 15;
//		lottoArray[2] = 27;
//		lottoArray[3] = 34;
//		lottoArray[4] = 36;
//		lottoArray[5] = 41;
		int[] lottoArray = { 5, 15, 27, 34, 36, 41 };

		// 전통적인 for
		for (int i = 0; i < lottoArray.length; ++i) {
			System.out.println("lottoArray[" + i + "] = " + lottoArray[i]);
		}

		// 성능이 빠른 foreach
		for (int number : lottoArray) {
			System.out.println(number);
		}

		// 반복범위가 명확한 데이터에 대해서는 이렇게 안함
		int j = 0;
		while (j < lottoArray.length) {
			System.out.println(lottoArray[j++]);
		}

		String str = "8. 핵무기가 완전히 없어졌고, 군축까지  착실하게 이행한 우크라이나는 전력이 크게 약해졌지만, 러시아는 침공을 했고, 미국과 영국이 지켜준다는 약속은 이행되지 않았음. \r\n"
				+ "[출처] 러시아 vs 우크라이나 전쟁 근황|작성자 메르";
		String[] wordArray = str.split(" ");

		for (String word : wordArray) {
			System.out.println(word);
		}
		for (int i = 0; i < wordArray.length; ++i) {
			if (wordArray[i].length() > 3) {
				System.out.println(wordArray[i]);
			}
		}

		// 홀수만 출력
//		for (int i = 0; i < 100; ++i) {
//			if (i % 2 == 1) {
//				System.out.println("홀수: " + i);
//			}
//		}

		// 홀수만 출력
//		for (int i = 0; i <= 100; ++i) {
//			if (i % 2 == 0) {
//				System.out.println("짝수: " + i);
//			}
//		}

	}
}
