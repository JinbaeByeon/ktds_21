package hospital;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
	List<Patient> patients = new ArrayList<Patient>();
	
	public void addPatients() {
		addPatient("민수", "감기");
		addPatient("영희", "콧물");
		addPatient("철수", "근육통");
	}
	
	public void addPatient(String name, String symptom) {
		patients.add(new Patient(name, symptom));
	}
	
	public void prescribe() {
		for(Patient patient: patients) {
			String symptom = patient.getSymptom();
			String medicine;
			if(symptom.equals("감기")) {
				medicine = "종합감기약";
			}
			else if (symptom.equals("콧물")) {
				medicine = "코막힘 약";
			}
			else if(symptom.equals("근육통")) {
				medicine = "근육이완제";
			}
			else {
				medicine = "없음";
			}
			patient.prescribed(medicine);
			patient.printPrescripty();
		}
	}

}
