package com.qaprosoft.hospital.models.medical;

import com.qaprosoft.hospital.models.IEat;

public class GeneralPractice extends MedicalEmployees implements IEat{
	private boolean surgicalPractice;

	public void diagnose() {

	}

	public boolean isSurgicalPractice() {
		return surgicalPractice;
	}

	public void setSurgicalPractice(boolean surgicalPractice) {
		this.surgicalPractice = surgicalPractice;
	}

	@Override
	public void heal() {

	}

	@Override
	public void eat() {
		System.out.println("Catering services two times a day");
		// TODO Auto-generated method stub
		
	}

}
