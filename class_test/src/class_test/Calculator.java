package class_test;

public class Calculator {
	public static void main(String[] args) {
		/*
		 * Primitive Type
		 *  byte, short, int, long
 		 *	float, double
 		 * 	char, boolean
		 *
		 * Reference Type
		 *  Primitive Type 제외 모든 타입
		 * 
		 * 변수 생성 방법
		 * Primitive Type
		 *  Type name = value;
		 *  
		 * Reference Type
		 *  Type name = new Type();
		 *   (String의 경우 Reference Type이지만, Primitive Type 처럼 변수 생성 가능하며 이 방법이 더 빠름)
		 * 
		 */
		ScoreCalculator scoreCalculator = new ScoreCalculator();
		scoreCalculator.getAvg();
		scoreCalculator.getGrade();

		TemperatureConverter temperatureConverter = new TemperatureConverter();
		temperatureConverter.toCel(0);
		temperatureConverter.toFah(0);
		
	}
}
