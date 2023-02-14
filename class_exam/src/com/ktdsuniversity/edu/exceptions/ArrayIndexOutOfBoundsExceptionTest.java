package com.ktdsuniversity.edu.exceptions;

public class ArrayIndexOutOfBoundsExceptionTest {

	public static void main(String[] args) {

		String[] nameArr = new String[3];
		nameArr[0] = "aaa";
		nameArr[1] = "bbb";
		nameArr[2] = "ccc";
		for (int i = 0; i < 5; ++i) {
			if (nameArr.length > i) {
				System.out.println(nameArr[i]);
			} else {
				break;
			}
		}

		String str = "와가두 출신의 흑인 여학생으로, 어머니가 호그와트의 점술 교수로 초빙되면서 어머니를 따라 호그와트로 전학왔다. 입학 첫날 수업에서 만날 수 있으며 주인공과 소환사의 코트라는 게임으로 대결을 하기도 한다.[1] 현명하고 재능있는 우등생으로, 정의를 추구한다. 우정이 깊어지면 주인공의 동료가 된다.\r\n";
		String[] wordArray = str.split(" ");
		
		if (wordArray.length > 50) {
			String word = wordArray[50];
			System.out.println(word);
		}
		
		try {
			String word = wordArray[50];
			System.out.println(word);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("그런사람없습니다");
		}
	}
}
