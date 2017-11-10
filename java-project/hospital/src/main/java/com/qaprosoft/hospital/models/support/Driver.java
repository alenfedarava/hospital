package com.qaprosoft.hospital.models.support;

import com.qaprosoft.hospital.models.IEat;

public class Driver extends Support implements IEat {
	private int drivingExp;
	private long id;

	public void drive() {

	}

	public int getDrivingExp() {
		return drivingExp;
	}

	public void setDrivingExp(int drivingExp) {
		this.drivingExp = drivingExp;
	}

	@Override
	public void service() {

	}

	@Override
	public void eat() {
		System.out.println("Dining room three times a day");
		// TODO Auto-generated method stub

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return "Driver:: ID=" + this.id + " Name=" + this.getFirstName() + " Surname=" + this.getLastName() + " Age="
				+ this.getAge() + " Address=" + this.getAddress() + " Role=" + this.getJobTitle()
				+ " Driving expierence=" + this.getDrivingExp() + " Address=" + this.getAddress() + " Date of Birth="
				+ this.getDateBirth();

	}

	public void setId(String value) {
		// TODO Auto-generated method stub
		
	}
}
