package com.qaprosoft.hospital.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import com.qaprosoft.hospital.models.parsers.DateConverter;

/**
 * The HospitalStaff class represents the structure of the whole hospital.
 * Particular departments should be added as a sub-classes to the HostitalStaff
 * class.
 * 
 * @author afedarava
 * @version 1.0
 * @since 2017-07-17
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class HospitalStaff extends AbstractEntity {
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private Integer age;
	/**
	 * The occupation of particular employee.
	 */
	@JsonProperty
	private String jobTitle;
	@JsonProperty
	private Address address;
	@XmlJavaTypeAdapter(DateConverter.class)
	@JsonProperty
	private Date dateBirth;

	public abstract void work();

	public Address getAddress() {
		return address;
	}
	@JsonSetter
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	@JsonSetter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	@JsonSetter
	public void setLastName(String string) {
		this.lastName = string;
	}

	public Integer getAge() {
		return age;
	}

	/**
	 * This is the method which is used to set the age of the object.
	 * 
	 * @param args
	 *            age
	 * @return nothing
	 * @exception AgeOutOfBoundsException
	 *                on input error.
	 * @see AgeOutOfBoundsException
	 */
	@JsonSetter
	public void setAge(Integer age) {
		// throws AgeOutOfBoundsException {
		// try {
		// if (age > 100 || age < 18)
		// ;
		// } catch (UncheckedIOException u) {
		// throw new AgeOutOfBoundsException("please enter a value between 10 and 100",
		// u);
		// }
		this.age = age;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	@JsonSetter
	public void setJobTitle(String string) {
		this.jobTitle = string;
	}

	public String getDateBirth() {
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(dateBirth);
	}
	@JsonSetter
	public void setDateBirth(String dateBirth) {
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			Date date = format.parse(dateBirth);
			this.dateBirth = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
