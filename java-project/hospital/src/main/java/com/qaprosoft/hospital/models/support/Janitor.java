package com.qaprosoft.hospital.models.support;

import com.qaprosoft.hospital.models.IEat;

public class Janitor extends Support implements IEat{
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
}
