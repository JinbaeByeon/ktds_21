package com.ktdsuniversity.edu.recursive;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Recursive {

	public int fibonacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		}
		return fibonacci(i - 2) + fibonacci(i - 1);
	}

	public long fibonacciDP(int i) {
		long[] dp = new long[i];
		dp[0] = 1;
		dp[1] = 1;
		for (int j = 2; j < i; ++j) {
			dp[j] = dp[j - 1] + dp[j - 2];
		}
		return dp[i - 1];

	}

	public void readFile(File file) {
		System.out.println(file.getAbsolutePath());

		List<File> fileList = Arrays.asList(file.listFiles());
		fileList.stream().filter(f -> f.isDirectory()).forEach(f -> readFile(f));
	}

	public static void main(String[] args) {
		Recursive rec = new Recursive();
//		System.out.println(rec.fibonacci(50));
		rec.readFile(new File("C:\\Devs"));
	}
}
