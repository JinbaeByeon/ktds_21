package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class ExampleCode {
	List<Dish> menu = new ArrayList<>();
	public ExampleCode() {
		for(int i=0;i<10;++i)
			menu.add(new Dish((char)('a'+i),i*80));
	}
	public void showMenu() {
		for(Dish d:menu) {
			System.out.println(d.getName() +", "+ d.getCalories());
		}
	}
	public void example(int i) {
		List<Dish> lowCaloricDishes = new ArrayList<>();
		showMenu();
		switch(i) {
			case 1:
				for(Dish d:menu) {
					if(d.getCalories() < 400) {
						lowCaloricDishes.add(d);
					}
				}
				
				Collections.sort(lowCaloricDishes,new Comparator<Dish>() {
					public int compare(Dish d1, Dish d2) {
						return Integer.compare(d1.getCalories(), d2.getCalories());
					}
				});
				
				List<String> lowCaloricDishesName = new ArrayList<>();
				for (Dish d : lowCaloricDishes) {
					lowCaloricDishesName.add(d.getName());
					d.print();
				}
				break;
				
			case 2:
				lowCaloricDishesName =
						menu.stream()
						.filter(d->d.getCalories()<400)
						.sorted(comparing(Dish::getCalories))
						.map(Dish::getName)
						.collect(toList());
				for(String name: lowCaloricDishesName)
					System.out.println(name);
				break;
				
			case 3:
				List<String> threeHighCaloricDishNames = 
						menu.stream()
						.filter(d->d.getCalories() > 300)
						.map(Dish::getName)
						.limit(3)
						.collect(toList());
				System.out.println(threeHighCaloricDishNames);
				break;
				
		}
	}

}
