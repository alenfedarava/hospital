package com.qaprosoft.hospital.models.medical;

import com.qaprosoft.hospital.models.IEat;

public class Surgeon extends MedicalEmployees implements IEat {

	private boolean therapeuticPractice;

	public void cut() {

	}

	public boolean isTherapeuticPractice() {
		return therapeuticPractice;
	}

	public void setTherapeuticPractice(boolean therapeuticPractice) {
		this.therapeuticPractice = therapeuticPractice;
	}

	@Override
	public void heal() {

	}

	@Override
	public void eat() {
		System.out.println("Catering services three times a day");

	}
}
