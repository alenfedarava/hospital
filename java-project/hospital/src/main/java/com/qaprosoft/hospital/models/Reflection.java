package com.qaprosoft.hospital.models;

import com.qaprosoft.hospital.models.*;
import com.qaprosoft.hospital.models.support.Support;

import java.lang.reflect.*;

public class Reflection {

	public static void main(String[] args) {

		Class hospClass = HospitalStaff.class;
		String hospClassName = hospClass.getName();
		Constructor[] constructors = hospClass.getDeclaredConstructors();
		Parameter[] parameters = constructors[0].getParameters();
		Method[] methods = hospClass.getDeclaredMethods();
		Field[] fields = hospClass.getDeclaredFields();
		System.out.println("the following class contains the methods below: ");
		for (Method m : methods) {
			System.out.println(m.getName());
		}
		System.out.println("the following class contains the fields below: ");
		for (Field f : fields) {
			System.out.println(f.getName());

		}
		Class supportClass = Support.class;
		Class superclass = supportClass.getSuperclass();
		System.out.println("the superclass for Support class is: " + supportClass.getSuperclass());
		Method[] methodsSupport = supportClass.getMethods();
		for (Method method : methodsSupport) {
			System.out.println("The name of the used method: " + method.getName());
			System.out.println("Return type: " + method.getReturnType().getName());

		}

	}
}
