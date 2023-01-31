package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Java", 100);
		map.put("C", 90);
		map.put("C#", 80);
		map.put("Python", 70);

		map.forEach((k, v) -> System.out.println(k + "\t: " + v));
		map.replace("Python",75,100);
		map.remove("C#");
		map.forEach((k, v) -> System.out.println(k + "\t: " + v));

	}
}
