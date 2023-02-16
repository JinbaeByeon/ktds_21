package com.ktdsuniversity.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordRelay {
	List<String> wordsList;

	public WordRelay() {
		wordsList = new ArrayList<>();
	}

	private boolean isCorrectWord(String str, String lastWord) {
		if (str.equals("포기") || !str.startsWith(lastWord)) {
			System.out.println("\"" + str + "\"" + StringUtil.selectBySupport(lastWord, "을", "를") + " 입력했습니다.");
			return false;
		} else {
			return true;
		}
	}

	private void printWordsList() {
		System.out.println("\n입력한 단어들은");
		wordsList.forEach(word -> System.out.println(word));
		System.out.println("입니다.");
	}

	public void gameStart() {
		Scanner scan = new Scanner(System.in);
		System.out.println("끝말잇기 게임 시작\n시작단어를 입력하세요.(3글자 이상)");
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

			if (!isCorrectWord(str, lastWord)) {
				System.out.println("게임이 종료됩니다.");
				break;
			} else if (len < 3) {
				System.out.println("\"" + str + "\"" + StringUtil.selectBySupport(str, "은 ", "는 ") + len
						+ "글자 입니다. 3글자 이상 단어를 입력하세요.");
			} else {
				wordsList.add(str);
				lastWord = str.substring(len - 1);
			}
		}
		printWordsList();
		scan.close();

	}

	public static void main(String[] args) {
		WordRelay cont = new WordRelay();
		cont.gameStart();
	}
}
