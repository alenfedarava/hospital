package com.qaprosoft.hospital.models.parsers;

import java.util.List;

import com.qaprosoft.hospital.models.administration.ChiefAccountant;
import com.qaprosoft.hospital.models.administration.ChiefMedical;
import com.qaprosoft.hospital.models.medical.GeneralPractice;
import com.qaprosoft.hospital.models.medical.Surgeon;
import com.qaprosoft.hospital.models.support.Driver;
import com.qaprosoft.hospital.models.support.Janitor;

public class HospitalJackson {

	public HospitalJackson() {
		super();
	}

	private List<Driver> drivers;
	private List<Janitor> janitors;
	private List<Surgeon> surgeons;
	private List<GeneralPractice> generalPractitioners;
	private List<ChiefAccountant> chiefAccountants;
	private List<ChiefMedical> chiefMedicals;

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Janitor> getJanitors() {
		return janitors;
	}

	public void setJanitors(List<Janitor> janitors) {
		this.janitors = janitors;
	}

	public List<Surgeon> getSurgeons() {
		return surgeons;
	}

	public void setSurgeons(List<Surgeon> surgeons) {
		this.surgeons = surgeons;
	}

	public List<GeneralPractice> getGeneralPractitioners() {
		return generalPractitioners;
	}

	public void setGeneralPractitioners(List<GeneralPractice> generalPractitioners) {
		this.generalPractitioners = generalPractitioners;
	}

	public List<ChiefAccountant> getChiefAccountants() {
		return chiefAccountants;
	}

	public void setChiefAccountants(List<ChiefAccountant> chiefAccountants) {
		this.chiefAccountants = chiefAccountants;
	}

	public List<ChiefMedical> getChiefMedicals() {
		return chiefMedicals;
	}

	public void setChiefMedicals(List<ChiefMedical> chiefMedicals) {
		this.chiefMedicals = chiefMedicals;
	}

}
