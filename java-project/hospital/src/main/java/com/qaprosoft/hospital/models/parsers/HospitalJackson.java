package com.qaprosoft.hospital.models.parsers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
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
	@JsonProperty
	private List<Driver> drivers;
	@JsonProperty
	private List<Janitor> janitors;
	@JsonProperty
	private List<Surgeon> surgeons;
	@JsonProperty
	private List<GeneralPractice> generalPractitioners;
	@JsonProperty
	private List<ChiefAccountant> chiefAccountants;
	@JsonProperty
	private List<ChiefMedical> chiefMedicals;

	public List<Driver> getDrivers() {
		return drivers;
	}
	@JsonSetter ("drivers")
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Janitor> getJanitors() {
		return janitors;
	}
	@JsonSetter ("janitors")
	public void setJanitors(List<Janitor> janitors) {
		this.janitors = janitors;
	}

	public List<Surgeon> getSurgeons() {
		return surgeons;
	}
	@JsonSetter ("surgeons")
	public void setSurgeons(List<Surgeon> surgeons) {
		this.surgeons = surgeons;
	}
	
	public List<GeneralPractice> getGeneralPractitioners() {
		return generalPractitioners;
	}
	@JsonSetter ("generalPractitioners")
	public void setGeneralPractitioners(List<GeneralPractice> generalPractitioners) {
		this.generalPractitioners = generalPractitioners;
	}

	public List<ChiefAccountant> getChiefAccountants() {
		return chiefAccountants;
	}
	@JsonSetter ("chiefAccountants")
	public void setChiefAccountants(List<ChiefAccountant> chiefAccountants) {
		this.chiefAccountants = chiefAccountants;
	}

	public List<ChiefMedical> getChiefMedicals() {
		return chiefMedicals;
	}
	@JsonSetter ("chiefMedicals")
	public void setChiefMedicals(List<ChiefMedical> chiefMedicals) {
		this.chiefMedicals = chiefMedicals;
	}

}
