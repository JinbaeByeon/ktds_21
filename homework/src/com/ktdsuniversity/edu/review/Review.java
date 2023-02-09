package com.ktdsuniversity.edu.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Review {
	private static Scanner scan = new Scanner(System.in);

	public static void test() {
		System.out.println("1. 정수형 변수 number를 생성하고 7을 할당한 후 출력하기");
		int number = 7;
		System.out.println(number);
		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("2. 정수형 변수 empty를 생성하고 아무것도 할당하지 않고 출력하기");
		int empty;
//		System.out.println(empty);  
		System.out.println("empty 변수에 값을 할당하지 않아서 실행안됨 (주석처리함)");

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("3. 정수형 변수 result를 생성하고 7과 7을 더한 후 출력하기");
		int result = 7 + 7;
		System.out.println(result);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("4. 정수형 변수 overflow를 생성하고 Integer.MAX_VALUE를 할당하고 출력하기"); // "2^31 -1
		int overflow = Integer.MAX_VALUE; // 0111'1111|1111'1111|1111'1111|1111'1111
		System.out.println(overflow);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("5. 정수형 변수 overflow에 1을 더해 할당하고 출력하기");
		System.out.println(++overflow); // 1000'0000|0000'0000|0000'0000|0000'0000

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("6. overflow 의 값이 이상하게 출력된 이유를 옆 사람에게 설명하기");
		System.out.println("MAX_VALUE의 값을 이진수로 표현하면 위의 19번 줄 주석 값인데, 여기서 1을 더하게 되면 22번 줄의 주석 값이 된다.");
		System.out.println("최상위 1비트값이 0이면 양수, 1이면 음수이므로 22번 주석의 이진수 값은 4바이트 정수로 표현할 수 있는 음의 최소값이 된다");

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("7. 6의 결과를 정상적인 값으로 출력되도록 변경해보기");
		System.out.println((long) --overflow + 1);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("8. overflow에 Integer.MIN_VALUE를 할당하고 출력하기");
		overflow = Integer.MIN_VALUE;
		System.out.println(overflow);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("9. 정수형 변수 overflow에 1을 빼서 할당하고 출력하기");
		System.out.println(--overflow);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("10. overflow 의 값이 이상하게 출력된 이유를 옆 사람에게 설명하기");
		System.out.println("6번의 답을 반대로 한것과 같다. 모르겠으면 말로 설명해드림");

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("11. 10의 결과를 정상적인 값으로 출력되도록 변경해보기");
		System.out.println((long) ++overflow - 1);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("12. 정수형 변수 divResult를 생성하고 10/3 의 결과를 할당해 출력하기");
		int divResult = 10 / 3;
		System.out.println(divResult);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("13. 소수점 이하 자리수가 안나오는 이유를 옆 사람에게 설명하기");
		System.out.println("정수 나누기 정수를 해서 정수형 변수에 할당했기 때문에 정수형으로 표현할 수 없는 수는 버림");

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("14. divResult의 값이 소수점이 나오도록 변경해보기");
		double divResult2 = (double) 10 / 3;
		System.out.println(divResult2);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("15. 불린형 변수 isEquals를 생성하고 1 == 1을 할당하고 출력하기");
		boolean isEquals = 1 == 1;
		System.out.println(isEquals);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("16. isEquals에 1 != 1을 할당하고 출력하기");
		isEquals = 1 != 1;
		System.out.println(isEquals);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("17. 불린형 변수 logicalAnd를 생성하고 true && true를 할당하고 출력하기");
		boolean logicalAnd = true && true;
		System.out.println(logicalAnd);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("18. logicalAnd에 true && false를 할당하고 출력하기");
		logicalAnd = true && false;
		System.out.println(logicalAnd);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("19. logicalAnd에 false && true를 할당하고 출력하기");
		logicalAnd = false && true;
		System.out.println(logicalAnd);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("20. logicalAnd에 false && false 를 할당하고 출력하기");
		logicalAnd = false && false;
		System.out.println(logicalAnd);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("21. 불린형 변수 logicalOr를 생성하고 true || true를 할당하고 출력하기");
		boolean logicalOr = true || true;
		System.out.println(logicalOr);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("22. 불린형 변수 logicalOr를 생성하고 true || false를 할당하고 출력하기");
		logicalOr = true || false;
		System.out.println(logicalOr);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("23. 불린형 변수 logicalOr를 생성하고 false || true를 할당하고 출력하기");
		logicalOr = false || true;
		System.out.println(logicalOr);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("24. 불린형 변수 logicalOr를 생성하고 false || false를 할당하고 출력하기");
		logicalOr = false || false;
		System.out.println(logicalOr);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("25. 5개의 인덱스를 가진 정수형 배열변수 scores를 생성하기");
		int[] scores = new int[5];

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("26. 각 인덱스에 임의의 값을 할당하기");
		for (int i = 0; i < 5; ++i) {
			scores[i] = i * 10;
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("27. 각 인덱스의 값을 모두 출력하기");
		System.out.println("28. 각 인덱스의 값을 반복문을 이용해 출력하기");
		for (int i = 0; i < 5; ++i) {
			System.out.println(scores[i]);
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("29. 각 인덱스의 값을 foreach문을 이용해 출력하기");
		for (int score : scores) {
			System.out.println(score);
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("30. 각 인덱스의 값을 모두 더해 출력하기");
		System.out.println("31. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기");
		System.out.println("32. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기");
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		System.out.println(sum);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 70 이하인 경우 출력하지 않도록 하기");
		for (int score : scores) {
			if (score > 70) {
				System.out.println(score);
			}
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 30보다 크고 70이하 인 경우만 출력하기");
		for (int score : scores) {
			if (30 < score && score <= 70) {
				System.out.println(score);
			}
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("35. List 정수형 변수 scoreList를 생성하기");
		List<Integer> scoreList = new ArrayList<>();

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("36. scoreList에 임의의 값 10개 할당하기");
		for (int i = 0; i < 10; ++i) {
			scoreList.add(i * 10);
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("37. 각 인덱스의 값을 모두 출력하기");
		System.out.println("38. 각 인덱스의 값을 반복문을 이용해 출력하기");
		for (int i = 0; i < 10; ++i) {
			System.out.println(scoreList.get(i));
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("39. 각 인덱스의 값을 foreach를 이용해 출력하기");
		for (int score : scoreList) {
			System.out.println(score);
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("40. 각 인덱스의 값을 모두 더해 출력하기");
		System.out.println("41. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기");
		sum = 0;
		for (int i = 0; i < 10; ++i) {
			sum += scoreList.get(i);
		}
		System.out.println(sum);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("42. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기");
		sum = 0;
		for (int score : scoreList) {
			sum += score;
		}
		System.out.println(sum);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("43. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 50 이하인 경우만 출력하기");
		for (int score : scoreList) {
			if (score <= 50) {
				System.out.println(score);
			}
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("44. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 10 이상 30이하인 경우만 출력하기");
		for (int score : scoreList) {
			if (10 <= score && score <= 30) {
				System.out.println(score);
			}
		}

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("45. \"안녕하세요\" 를 출력하는 printHello 메소드를 작성하고 실행하기");
		printHello();

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("46. 문자열 변수 name을 입력받아 \"name님 안녕하세요\" 를 출력하는 printHello 메소드를 작성하고 실행하기");
		printHello("이름");

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("47. 정수형 변수 두 개를 입력받아 각 값을 곱하여 출력하는 multiplyNumbers 메소드를 작성하고 실행하기");
		multiplyNumbers(10, 20);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("48. 정수형 변수 세 개를 입력받아 각 값을 더하여 출력하는 plusNumbers 메소드를 작성하고 실행하기");
		plusNumbers(10, 20, 30);

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("49. 정수형 변수 한 개를 입력받고 값이 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기");
		System.out.println(convertSymbol(10));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("50. 정수형 변수 두 개를 입력받아 뺀 후 결과가 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기");
		System.out.println(convertSymbol(10, 20));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("51. 문자열 변수 하나를 입력받아 문자열의 길이를 반환하는 getLength 메소드를 작성하고 실행하기");
		System.out.println(getLength("이 문자열의 길이는 13"));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("52. 문자열 변수 두 개를 입력받아 각 문자열을 더하여 반환하는 plusStrings 메소드를 작성하고 실행하기");
		System.out.println(plusStrings("문자열을 ", "합쳐주세요"));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("53. 문자열 변수 세 개를 입력받아 길이가 가장 긴 문자열만 반환하는 getLongText 메소드를 작성하고 실행하기");
		System.out.println(getLongText("길이가 가장 긴", "문자열만", "반환해라"));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("54. 문자열 변수 하나와 정수형 변수 두 개를 입력받아 입력받은 두 숫자만큼 문자열을 잘라 반환하는 getSubstring메소드를 작성하고 실행하기");
		System.out.println(getSubstring("입력받은 두 숫자만큼 문자열을 잘라서 반환", 5, 10));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("55. 문자열 변수 두 개를 입력받아 첫 번째 문자열에서 두 번째 문자열이 포함되어있는지를 반환하는 isContains메소스를 작성하고 실행하기");
		System.out.println(isContains("첫 번째 문자열에 두 번째 문자열이 포함됐나", "포함"));

		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("56. 문자열 변수 세 개를 입력받아 첫 번째 문자열에서 두 번째 문자열을 세 번째 문자열로 교체하여 반환하는 getReplaced 메소드를 작성하고 실행하기");
		System.out.println(getReplaced("이 문자열에서 두 번째 문자열이 있으면 세 번째 문자열로 교체", "문자열", "String"));
	}

	private static String getReplaced(String str, String oldStr, String newStr) {

		return str.replace(oldStr, newStr);
	}

	private static boolean isContains(String str, String target) {
		return str.contains(target);
	}

	private static String getSubstring(String str, int bIdx, int eIdx) {
		return str.substring(bIdx, eIdx);
	}

	private static String getLongText(String str1, String str2, String str3) {
		int len1 = str1.length();
		int len2 = str2.length();
		int len3 = str3.length();

		if (len1 >= len3) {
			if (len1 >= len2) {
				return str1;
			} else {
				return str2;
			}
		} else if (len2 >= len3) {
			return str2;
		} else {
			return str3;
		}
	}

	private static String plusStrings(String str1, String str2) {
		return str1 + str2;
	}

	private static int getLength(String str) {
		return str.length();
	}

	private static int convertSymbol(int num1, int num2) {
		return num2 - num1;
	}

	private static int convertSymbol(int num) {
		return -num;
	}

	private static void plusNumbers(int i, int j, int k) {
		System.out.println(i + j + k);
	}

	private static void multiplyNumbers(int i, int j) {
		System.out.println(i * j);
	}

	private static void printHello(String name) {
		System.out.println(name + "님 안녕하세요");
	}

	private static void printHello() {
		System.out.println("안녕하세요");
	}

	/**
	 * 교육 시간 나가는 실습 예제는 여기다가 테스트
	 */
	public static void test2() {
//		Random rd = new Random();
//		avgCalcArr(rd);
//		avgCalcList(rd);
//		avgCalcMap(rd);
//		watchMovie();
//		loop3();
//		infinityLoop(rd);
		printNumber();
	}

	public static void printNumber() {
		Random rd = new Random();
		int[] arr = new int[50];
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = rd.nextInt(100);
		}

		for (int num : arr) {
			if (num % 3 == 0 && num != 0) {
				System.out.println(num);
			}
		}
	}

	public static void infinityLoop(Random rd) {
		String str = "";
		while (true) {
			System.out.println("명령어를 입력하세요.");
			str = scan.nextLine();
			if (str.contains("keep")) {
				if (str.contains("1")) {
					avgCalcArr(rd);
				} else if (str.contains("2")) {
					avgCalcList(rd);
				} else {
					avgCalcMap(rd);
				}
			} else if (str.equals("quit")) {
				break;
			}
		}
	}

	public static void loop3() {

		int age = 0;
		for (int i = 0; i < 3; ++i) {
			System.out.println("나이를 입력하세요.");
			age = scan.nextInt();
			scan.nextLine();
			if (age >= 19) {
				System.out.println("성인입니다.");
			} else {
				System.out.println("미성년입니다.");
			}
		}
		System.out.println();
	}

	public static void watchMovie() {
		int money = 20_000;
		int age = 27;
		if (money >= 18000 && age >= 27) {
			System.out.println("슬램덩크 볼 수 있음");
		}
	}

	public static void gradeByAvg(double avg) {
		System.out.println("평균 : " + avg);
		String grade = "F";
//		if (0b110_0100 > avg && avg >= 0b101_1111) {
//			grade = "A+";
//		} else if (0b101_1111 > avg && avg >= 0b101_1010) {
//			grade = "A";
//		} else if (0b101_1010 > avg && avg >= 0b101_0101) {
//			grade = "B+";
//		} else if (0b101_0101 > avg && avg >= 0b101_0000) {
//			grade = "B";
//		} else if (0b101_0000 > avg && avg >= 0b100_0110) {
//			grade = "C";
//		} else if (0b100_0110 > avg && avg >= 0b011_1011) {
//			grade = "D";
//		} else if (0b000_0000 <= avg && avg < 0b011_1011) {
//			grade = "F";
//		}

		if (0x64 > avg && avg >= 0x5f) {
			grade = "A+";
		} else if (0x5f > avg && avg >= 0x5a) {
			grade = "A";
		} else if (0x5a > avg && avg >= 0x55) {
			grade = "B+";
		} else if (0x55 > avg && avg >= 0x50) {
			grade = "B";
		} else if (0x50 > avg && avg >= 0x46) {
			grade = "C";
		} else if (0x46 > avg && avg >= 0x3b) {
			grade = "D";
		} else if (0x00 <= avg && avg < 0x3b) {
			grade = "F";
		}
		System.out.println(grade);
	}

	public static void avgCalcArr(Random rd) {
		double avg = 0;
		int[] scoreArr = new int[4];
		int lenArr = scoreArr.length;

		for (int i = 0; i < lenArr; ++i) {
			scoreArr[i] = 55 + rd.nextInt(46);
			System.out.println("과목" + i + " 점수 : " + scoreArr[i]);
		}
		for (int score : scoreArr) {
			avg += score / (double) lenArr;
		}
		gradeByAvg(avg);
	}

	public static void avgCalcList(Random rd) {
		double avg = 0;
		List<Integer> scoreList = new ArrayList<>();
		for (int i = 0; i < 4; ++i) {
			scoreList.add(55 + rd.nextInt(46));
			System.out.println("과목" + i + " 점수 : " + scoreList.get(i));
		}
		for (int score : scoreList) {
			avg += score / (double) scoreList.size();

		}
		gradeByAvg(avg);
	}

	public static void avgCalcMap(Random rd) {
		double avg = 0;
		Map<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("수학", 55 + rd.nextInt(46));
		scoreMap.put("물리", 55 + rd.nextInt(46));
		scoreMap.put("영어", 55 + rd.nextInt(46));
		scoreMap.put("프로그래밍", 55 + rd.nextInt(46));

		for (Entry<String, Integer> e : scoreMap.entrySet()) {
			String subject = e.getKey();
			int score = e.getValue();
			System.out.println(subject + " 점수 : " + score);
			avg += score;
		}
		avg /= (double) scoreMap.size();

		gradeByAvg(avg);
	}

	public static void main(String[] args) {
//		test();
		test2();
		scan.close();
	}
}
