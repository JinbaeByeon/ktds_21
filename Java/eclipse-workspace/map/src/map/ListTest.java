package map;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("100");
		if(strList.contains("100")) {
			System.out.println("100 은 이미 등록되었습니다.");
		}
	}
}
