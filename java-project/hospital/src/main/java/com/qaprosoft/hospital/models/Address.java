package com.qaprosoft.hospital.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement(name = "address")
@JsonRootName(value = "address")
public class Address extends AbstractEntity{
	@JsonProperty
	private String street;
	@JsonProperty
	private int houseNumber;
	@JsonProperty
	private String phone;
	@JsonProperty
	private Cities cities;

	Address(String city, String street, int houseNumber, String phone, Cities cities) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.phone = phone;
		this.setCities(cities);
		this.cities = cities;
	}

	public Address() {

	}

	public String toString() {
		return this.cities + this.street + this.houseNumber + this.phone;
	}

	public String getStreet() {
		return street;
	}

	@XmlElement(name = "street")
	@JsonSetter(value = "street")
	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	@XmlElement(name = "houseNumber")
	@JsonSetter(value = "houseNumber")
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPhone() {
		return phone;
	}

	@XmlElement(name = "phone")
	@JsonSetter(value = "phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement(name = "cities")
	@JsonSetter(value = "cities")
	public Cities getCities() {
		return cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + houseNumber;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (cities != other.cities)
			return false;
		if (houseNumber != other.houseNumber)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	public void setCities(Cities cities) {
		this.cities = cities;
	}
	

}
