package com.qaprosoft.hospital.models.support;

import com.qaprosoft.hospital.models.HospitalStaff;

/**
 * The Support class is used to represent the group of employers, which are
 * provide services like cleaning, driving and catering.
 * 
 * @author afedarava
 * @version 1.0
 * @since 2017-07-17
 */
public abstract class Support extends HospitalStaff {
	private boolean relatedEducation;
	/**
	 * shows the availability of benefits
	 */
	private boolean privileges;

	public void work() {

	}

	public abstract void service();

	public boolean isRelatedEducation() {
		return relatedEducation;
	}

	public void setRelatedEducation(boolean relatedEducation) {
		this.relatedEducation = relatedEducation;
	}

	public boolean isPrivileges() {
		return privileges;
	}

	public void setPrivileges(boolean privileges) {
		this.privileges = privileges;
	}

}
