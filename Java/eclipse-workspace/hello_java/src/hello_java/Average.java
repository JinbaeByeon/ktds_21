package hello_java;
/**
 * 과목의 평균 구하기
 * @author User
 *
 */
public class Average {
	public static void main(String[] args) {
		// 4가지 과목의 점수
		int scoreMath = 65;
		int scorePhy = 56;
		int scoreEng = 78;
		int scorePro = 82;
		
		/*
		 * 4가지 과목의 평균을 구해 avg에 넣기
		 */
		double avg = (scoreMath + scorePhy + scoreEng + scorePro)/4.;
		
		System.out.println("Average: " + avg);
	}
}
