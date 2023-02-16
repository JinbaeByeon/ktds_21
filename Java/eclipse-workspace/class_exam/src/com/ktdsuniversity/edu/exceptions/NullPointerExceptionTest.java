package com.ktdsuniversity.edu.exceptions;

import java.util.HashMap;
import java.util.Map;

public class NullPointerExceptionTest {

	public static String getName(int lenName) {
		if (lenName == 2) {
			return "aa";
		} else if (lenName == 3) {
			return "bbb";
		} else if (lenName == 4) {
			return "cccc";
		}
		return null;
	}

	public static String nullToDefault(String str, String defVal) {
		return str == null ? defVal : str;
	}

	public static String nullToEmpty(String str) {
		return str == null ? "" : str;
	}

	public static void main(String[] args) {
		String name = nullToEmpty(getName(1));
//		if (name == null) {
//			name = "";
//		}

		boolean isAStart = name.startsWith("A");
		System.out.println(isAStart);

		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("a", "aa");
		nameMap.put("b", "ba");
		nameMap.put("c", "ca");

//		if (nameMap.containsKey("d")) {
//			String fullName = nameMap.get("d");
//			String lastName = fullName.substring(0, 1);
//			System.out.println(lastName);
//		}

		String fullName = nullToEmpty(nameMap.get("d"));
		if (fullName.length() > 0) {
			String lastName = fullName.substring(0, 1);
			System.out.println(lastName);
		} else {
			System.out.println("no data");
		}
	}
}
