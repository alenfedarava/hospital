package com.qaprosoft.hospital.models.sax;

import java.util.Date;

import com.qaprosoft.hospital.models.Address;

public class Hospital {

	private String lastName;
	private int age;
	private String jobTitle;
	private Address address;
	private Date dateBirth;
	private int drivingExp;
	private boolean useInstruments;
	private boolean therapeuticPractice;
	private boolean surgicalPractice;
	private boolean economicEducation;
	private boolean phD;
	private String awards;

	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public int getDrivingExp() {
		return drivingExp;
	}

	public void setDrivingExp(int drivingExp) {
		this.drivingExp = drivingExp;
	}

	public boolean isUseInstruments() {
		return useInstruments;
	}

	public void setUseInstruments(boolean useInstruments) {
		this.useInstruments = useInstruments;
	}

	public boolean isTherapeuticPractice() {
		return therapeuticPractice;
	}

	public void setTherapeuticPractice(boolean therapeuticPractice) {
		this.therapeuticPractice = therapeuticPractice;
	}

	public boolean isSurgicalPractice() {
		return surgicalPractice;
	}

	public void setSurgicalPractice(boolean surgicalPractice) {
		this.surgicalPractice = surgicalPractice;
	}

	public boolean isEconomicEducation() {
		return economicEducation;
	}

	public void setEconomicEducation(boolean economicEducation) {
		this.economicEducation = economicEducation;
	}

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

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
    public String toString() {
        return "Hospital:: ID="+this.id+" Name=" + this.firstName + " Surname=" + this.lastName +" Age=" + this.age + " Address=" + this.address +
                " Role=" + this.jobTitle + " Date of Birth=" + this.dateBirth;
    } 
}
