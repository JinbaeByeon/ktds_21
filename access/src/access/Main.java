package access;

public class Main {
	public static void main(String[] args) {
		Public pub = new Public();

		pub.add();
		int publicNumberOne = pub.getNumber1();
		System.out.println(publicNumberOne);

		pub.setNumber1(10);

		int publicNumberTwo = pub.getNumber2();
		System.out.println(publicNumberTwo);
		
		pub.setNumber2(15);

		pub.add();

	}
}
