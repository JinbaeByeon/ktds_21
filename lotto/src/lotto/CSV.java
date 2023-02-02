package lotto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSV {

	public static void main(String[] args) {
		try {
			// 1. 파일을 읽어온다.
			List<String> csv = Files.readAllLines(Paths.get("C:\\Users\\User\\Desktop\\점수표.csv"));

			// 2. 라인별로 반복한다.
			for (String line : csv) {
				if (line.equals(csv.get(0))) {
					continue;
				}
				// 라인을 ","로 분리한다.
				String[] words = line.split(",");
				// 분리된 텍스트를 반복하여 출력한다.
//				for (String word : words) {
//					System.out.printf(word + " ");
//				}
				System.out.println(words[0] + "과목의 점수는 "+ words[1] + "점이고, 등급은 " +words[2] +"입니다." );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
