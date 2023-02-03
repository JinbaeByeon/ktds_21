package com.ktdsuniversity.edu;

public class StringUtil {
	/**
	 * 
	 * @param word
	 * @param first
	 * @param second
	 * @return
	 */
	public static final String selectBySupport(String word, String first, String second) {
		char lastWord = word.charAt(word.length() - 1);
		int idx = (lastWord - 0xAC00) % 28;
		final String select = idx > 0 ? first : second;

		return select;
	}

	public static final boolean startsWith(String targetWord, String compareWord) {
		return targetWord.substring(0, compareWord.length()).equals(compareWord);
	}

	public static final boolean endsWith(String targetWord, String compareWord) {
		return targetWord.lastIndexOf(compareWord) == targetWord.length() - compareWord.length();
	}

	public static final boolean contains(String targetWord, String compareWord) {
		return targetWord.indexOf(compareWord) > -1;
	}

}
