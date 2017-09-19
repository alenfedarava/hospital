package com.qaprosoft.hospital.models.administration;

import com.qaprosoft.hospital.models.IEat;

public class ChiefAccountant extends Administration implements IEat {
	private boolean economicEducation;

	public void payMoney() {

	}

	public boolean isEconomicEducation() {
		return economicEducation;
	}

	public void setEconomicEducation(boolean economicEducation) {
		this.economicEducation = economicEducation;
	}

	@Override
	public void decMaker() {
		super.work();
		System.out.println("give (someone) money");
	}

	@Override
	public void eat() {
		System.out.println("Catering services two times a week");

	}

}
