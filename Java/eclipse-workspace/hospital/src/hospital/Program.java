package hospital;

public class Program {
	Pharmacy pharmacy = new Pharmacy();
	
	public static void main(String[] args) {
		Program program = new Program();
		program.pharmacy.addPatients();
		program.pharmacy.prescribe();
	}

}
