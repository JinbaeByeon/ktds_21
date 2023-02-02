package com.ktdsuniversity.edu.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileWriter {

	public static File createNewFile() throws IOException {
		File textFile = new File("C:\\logs11", "test.txt");
		textFile.createNewFile();
		return textFile;
	}

	public static File createNewFileThrowsRuntimeException() {
		File textFile = new File("C:\\logssss", "text.txt");
		try {
			textFile.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return textFile;
	}

	public static void main(String[] args) {
		File textFile = new File("C:\\logs", "test.txt");
		Scanner scan = new Scanner(System.in);

		if (true/* textFile.exists() && textFile.isFile() */) {
			OutputStream fos = null;
			try {
				fos = new FileOutputStream(textFile);
				while (true) {
					String str = scan.nextLine();
					if (str.equals("q")) {
						break;
					}
					fos.write(str.getBytes());
					fos.flush();
				}
			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {}
				}
			}
		}
		System.out.println("메인 끝");
	}
}
