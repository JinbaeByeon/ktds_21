package com.ktdsuniversity.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordRelayTryCatch {
	List<String> wordsList;

	public WordRelayTryCatch() {
		wordsList = new ArrayList<>();
	}

	private void checkWord(String str, String lastWord) {
		if (str.equals("포기") || !str.startsWith(lastWord)) {
			throw new ExitWordException();
		}
		if(str.length()<3) {
			throw new WordLengthException();
		}
	}

	private void printWordsList() {
		System.out.println("\n입력한 단어들은");
		wordsList.forEach(word -> System.out.println(word));
		System.out.println("입니다.");
	}

	public void gameStart() {
		Scanner scan = new Scanner(System.in);
		System.out.println("끝말잇기 게임 - tryCatch 시작\n시작단어를 입력하세요.(3글자 이상)");
		new ArrayList<>();
		String str = null;
		int len = 0;
		String lastWord = "";
		while (true) {
			if (str != null) {
				System.out.println(
						"\"" + lastWord + "\"" + StringUtil.selectBySupport(lastWord, "으로 ", "로 ") + "시작하는 단어를 입력하세요.");
			}
			System.out.printf("> ");
			str = scan.nextLine().trim().replace(" ", "");
			len = str.length();

			try {
				checkWord(str,lastWord);
				wordsList.add(str);
				lastWord = str.substring(len - 1);
			}
			catch(ExitWordException e) {
				System.out.println("\"" + str + "\"" + StringUtil.selectBySupport(str, "을", "를") + " 입력했습니다.");
				System.out.println("게임이 종료됩니다.");
				break;
			}
			catch(WordLengthException e) {
				System.out.println("\"" + str + "\"" + StringUtil.selectBySupport(str, "은 ", "는 ") + len
						+ "글자 입니다.\n3글자 이상 단어를 입력하세요.");				
			}
			
		}
		printWordsList();
		scan.close();

	}

	public static void main(String[] args) {
		WordRelayTryCatch cont = new WordRelayTryCatch();
		cont.gameStart();
	}
}
