package com.qaprosoft.hospital.models.administration;

import com.qaprosoft.hospital.models.AbstractEntity;
import com.qaprosoft.hospital.models.HospitalStaff;

/**
 * The Administration class represents administrative department of the
 * hospital.
 * 
 * @author afedarava
 * @version 1.0
 * @since 2017-07-17
 */
public abstract class Administration extends HospitalStaff {

	private int salaryRate;
	private boolean personalRoom;
	/**
	 * Quantity of subordinates of particular employee.
	 */
	private int subordinates;

	public abstract void decMaker();

	@Override
	public void work() {
		System.out.println("making decisions");
	}

	public int salaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(int salaryRate) {
		this.salaryRate = salaryRate;
	}

	public boolean isPersonalRoom() {
		return personalRoom;
	}

	public void setPersonalRoom(boolean personalRoom) {
		this.personalRoom = personalRoom;
	}

	public int getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(int subordinates) {
		this.subordinates = subordinates;
	}

}
