package hello_java;

/**
 * 섭씨를 화씨로 변경
 * 
 * @author jbbyeon
 *
 */
public class CelToFah {
	public static void main(String[] args) {
		// 섭씨
		int cel = 38;

		/*
		 * 섭씨를 화씨로 변경해 fah 변수에 할당 후 출력
		 */
		double fah = cel * 1.8 + 32;

		System.out.println(cel + " -> " + fah);

		cel = (int) ((fah - 32) / 1.8);
		System.out.println(fah + " -> " + cel);
	}

}
