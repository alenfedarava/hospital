package com.qaprosoft.hospital.models.administration;

import com.qaprosoft.hospital.models.IEat;

public class ChiefMedical extends Administration implements IEat{

	private boolean phD;
	private String awards;

	public boolean isPhD() {
		return phD;
	}

	public void setPhD(boolean phD) {
		this.phD = phD;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	@Override
	public void decMaker() {
		super.work();
		System.out.println("to cause to retire from one's position or occupation");
	}

	@Override
	public void eat() {
		System.out.println("Catering services once a day");
		
	}

}
