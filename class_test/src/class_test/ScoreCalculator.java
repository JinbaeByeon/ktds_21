package class_test;

public class ScoreCalculator {
	int scoreA = 65;
	int scoreB = 56;
	int scoreC = 78;
	int scoreD = 82;
	/**
	 * 4과목의 평균을 계산
	 */
	public void getAvg() {
		int sum = scoreA + scoreB + scoreC + scoreD;
		
		/*
		 * 4가지 과목의 평균을 구해 avg에 넣기
		 */
		double avg = sum / 4.;

		System.out.println("Average: " + avg);
	}
	
	public void getGrade() {
		int sum = scoreA + scoreB + scoreC + scoreD;
		double avg = sum /4.;
		String grade;
		if(avg>=95) grade = "A+";
		else if(avg>=90) grade = "A";
		else if(avg>=85) grade = "B+";
		else if(avg>=80) grade = "B";
		else if(avg>=70) grade = "C";
		else if(avg>=60) grade = "D";
		else grade = "F";
		
		System.out.println("Grade: " + grade);
	}
}
