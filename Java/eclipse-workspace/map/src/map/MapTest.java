package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("Java", 100);
		map.put("C", 90);
		map.put("C#", 80);
		map.put("Python", 70);
		map.put("Language", new ArrayList<>());

		map.forEach((k, v) -> System.out.println(k + "\t: " + v));

		map.replace("Python",75,100);
		map.remove("C#");
		map.forEach((k, v) -> System.out.println(k + "\t: " + v));
		Set<String> keys = map.keySet();
		
		System.out.println("\nSet for");
		for(String key : keys) {
			System.out.println(key + "\t: " + map.get(key));
		}
	}
}
