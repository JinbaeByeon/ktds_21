package stream;

import java.util.Random;

public class Dish {
	private int calories;
	private String name="";
	public int getCalories() {
		return calories;
	}
	public String getName() {
		return name;
	}
	public void print() {
		System.out.println("음식이름: " + name + " (칼로리: " + calories + ")");
	}

	Dish(){
		Random rd = new Random();
		for(int i=0;i<7;++i) {
			name += (char)('a'+rd.nextInt(26)); 
		}
		calories = 300 + rd.nextInt(200);
	}
	Dish(String n,int cal){
		name= n;
		calories = cal;
	}

	Dish(char n,int cal){
		name += n;
		calories = cal;
	}
}
