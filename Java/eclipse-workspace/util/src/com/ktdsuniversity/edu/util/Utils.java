package com.ktdsuniversity.edu.util;

public class Utils {

	private Utils() {
	}

	public static byte toByte(String str) {
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static byte toByte(String str, byte defaultValue) {
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static short toShort(String str) {
		try {
			return Short.parseShort(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static short toShort(String str, short defaultValue) {
		try {
			return Short.parseShort(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int toInt(String str, int defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static long toLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return 0L;
		}
	}

	public static long toLong(String str, long defaultValue) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static float toFloat(String str) {
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return 0.f;
		}
	}

	public static float toFloat(String str, float defaultValue) {
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static double toDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return 0.;
		}
	}

	public static double toDouble(String str, double defaultValue) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static Boolean isEquals(String str1, String str2) {
		try {
			return str1.equals(str2);
		} catch (NullPointerException e) {
			return false;
		}
	}
}
