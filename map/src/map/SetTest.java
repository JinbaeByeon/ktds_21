package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		Set<String> strSet = new HashSet<>();
		
		strSet.add("100");
		strSet.add("101");
		strSet.add("102");
		strSet.add("103");
		strSet.add("104");
		strSet.add("105");
		
		System.out.println(strSet.size());
		for(String str: strSet) {
			System.out.println(str);
		}

		Iterator<String> iterStr = strSet.iterator();
		// 아래의 for문과 while문은 같음
		
		for(;iterStr.hasNext();) {
			System.out.println(iterStr.next());
		}		
		
		while(iterStr.hasNext()) {
			System.out.println(iterStr.next());
		}
	}
}
