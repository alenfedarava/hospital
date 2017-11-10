package com.qaprosoft.hospital.models.support;

import com.qaprosoft.hospital.models.IEat;

public class Janitor extends Support implements IEat {
	private boolean useInstruments;

	public void clean() {

	}

	@Override
	public void service() {

	}

	public boolean isUseInstruments() {
		return useInstruments;
	}

	public void setUseInstruments(boolean useInstruments) {
		this.useInstruments = useInstruments;
	}

	@Override
	public void eat() {
		System.out.println("Dining room two times a day");
		// TODO Auto-generated method stub

	}

	public String toString() {
		return "Janitor:: " + "Name=" + this.getFirstName() + " Surname=" + this.getLastName() + " Age="
				+ this.getAge() + " Address=" + this.getAddress() + " Role=" + this.getJobTitle()
				+ " Use instruments=" + this.isUseInstruments() + " Address=" + this.getAddress() + " Date of Birth="
				+ this.getDateBirth();
	}
}
