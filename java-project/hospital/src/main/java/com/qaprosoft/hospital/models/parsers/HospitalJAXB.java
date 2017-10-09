package com.qaprosoft.hospital.models.parsers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.qaprosoft.hospital.models.administration.ChiefAccountant;
import com.qaprosoft.hospital.models.administration.ChiefMedical;
import com.qaprosoft.hospital.models.medical.GeneralPractice;
import com.qaprosoft.hospital.models.medical.Surgeon;
import com.qaprosoft.hospital.models.support.Driver;
import com.qaprosoft.hospital.models.support.Janitor;

@XmlRootElement(name = "hospital")
@XmlAccessorType(XmlAccessType.FIELD)
public class HospitalJAXB {
	
	@XmlElementWrapper(name="drivers")
	@XmlElement(name = "driver")
	private List<Driver> driversList;

	@XmlElementWrapper(name="janitors")
	@XmlElement(name = "janitor")
	private List<Janitor> janitorsList;

	@XmlElementWrapper(name="surgeons")
	@XmlElement(name = "surgeon")
	private List<Surgeon> surgeonsList;

	@XmlElementWrapper(name="generalPractitioners")
	@XmlElement(name = "generalPractice")
	private List<GeneralPractice> generalPractitionersList;

	@XmlElementWrapper(name="chiefAccountants")
	@XmlElement(name = "chiefAccountant")
	private List<ChiefAccountant> chiefAccountantsList;

	@XmlElementWrapper(name="chiefMedicals")
	@XmlElement(name = "chiefMedical")
	private List<ChiefMedical> chiefMedicalsList;

	public List<Driver> getDriversList() {
		return driversList;
	}

	public void setDriversList(List<Driver> driversList) {
		this.driversList = driversList;
	}

	public List<Janitor> getJanitorsList() {
		return janitorsList;
	}

	public void setJanitorsList(List<Janitor> janitorsList) {
		this.janitorsList = janitorsList;
	}

	public List<Surgeon> getSurgeonsList() {
		return surgeonsList;
	}

	public void setSurgeonsList(List<Surgeon> surgeonsList) {
		this.surgeonsList = surgeonsList;
	}

	public List<GeneralPractice> getGeneralPractitionersList() {
		return generalPractitionersList;
	}

	public void setGeneralPractitionersList(List<GeneralPractice> generalPractitionersList) {
		this.generalPractitionersList = generalPractitionersList;
	}

	public List<ChiefAccountant> getChiefAccountantsList() {
		return chiefAccountantsList;
	}

	public void setChiefAccountantsList(List<ChiefAccountant> chiefAccountantsList) {
		this.chiefAccountantsList = chiefAccountantsList;
	}

	public List<ChiefMedical> getChiefMedicalsList() {
		return chiefMedicalsList;
	}

	public void setChiefMedicalsList(List<ChiefMedical> chiefMedicalsList) {
		this.chiefMedicalsList = chiefMedicalsList;
	}

	public HospitalJAXB() {
		super();
	}
}
