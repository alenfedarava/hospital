package com.qaprosoft.hospital.models.medical;

import com.qaprosoft.hospital.models.HospitalStaff;
/**
 * The MedicalEmployyes class represents different medical departments of the
 * hospital.
 * 
 * @author afedarava
 * @version 1.0
 * @since 2017-07-17
 */
public abstract class MedicalEmployees extends HospitalStaff {
	private String specialization;
	private boolean nightShift;
	/**
	 * the number of years worked in the specialty
	 */
	private int medicalExp;
	
	public abstract void heal();

	@Override
	public void work() {

	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public boolean isNightShift() {
		return nightShift;
	}

	public void setNightShift(boolean nightShift) {
		this.nightShift = nightShift;
	}

	public int getMedicalExp() {
		return medicalExp;
	}

	public void setMedicalExp(int medicalExp) {
		this.medicalExp = medicalExp;
	}
	static String[] names = new String[] { "Ivan", "Dzmitry", "Alexey", "Nikolay", "Vitaly", "Anton", "Anna", "Vadim" , "Igor", "Stanislav" };

	public static void main(String[] args) {
		MedicalEmployees[] medics = new MedicalEmployees[10];
		for(int i = 0; i < medics.length / 2; i++)
		{
			medics[i] = new GeneralPractice();
			medics[i].setMedicalExp(3 + i);
			medics[i].setFirstName(names[i]);
		}
		for(int i = medics.length / 2; i < medics.length; i++)
		{
			medics[i] = new Surgeon();
			medics[i].setMedicalExp(3 + i);
			medics[i].setFirstName(names[i]);
		}
		
		for(MedicalEmployees medic: medics) {
			if(medic.getMedicalExp() > 5) {
				System.out.println("Medic name: " + medic.getFirstName() );
				System.out.print("Medic exp: " + medic.getMedicalExp());
				System.out.println("\n");
			}
		}
		
}



	
}
