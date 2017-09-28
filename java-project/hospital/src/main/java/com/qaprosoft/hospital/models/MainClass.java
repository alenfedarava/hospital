package com.qaprosoft.hospital.models;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.qaprosoft.hospital.models.administration.Administration;
import com.qaprosoft.hospital.models.administration.ChiefAccountant;
import com.qaprosoft.hospital.models.administration.ChiefMedical;
import com.qaprosoft.hospital.models.medical.GeneralPractice;
import com.qaprosoft.hospital.models.medical.Surgeon;
import com.qaprosoft.hospital.models.support.Driver;
import com.qaprosoft.hospital.models.support.Janitor;
import com.qaprosoft.hospital.models.*;
public class MainClass {

	public static void main(String[] args) throws AgeOutOfBoundsException, UncheckedIOException {

		Address a1 = new Address();
		a1.setHouseNumber(6);
		a1.setPhone("+375298916677");
		a1.setStreet("Lenina");
		a1.setCities(Cities.BORISOV);

		Address a2 = new Address();
		a2.setHouseNumber(2);
		a2.setPhone("+375292020327");
		a2.setStreet("Novaya");
		a2.setCities(Cities.CHERVEN);

		Address a3 = new Address();
		a3.setHouseNumber(3);
		a3.setPhone("+375338972166");
		a3.setStreet("Raduzhnaya");
		a3.setCities(Cities.DZERZHINSK);

		Address a4 = new Address();
		a4.setHouseNumber(4);
		a4.setPhone("+375259236166");
		a4.setStreet("Komsomolskaya");
		a4.setCities(Cities.FANIPOL);

		Address a5 = new Address();
		a5.setHouseNumber(5);
		a5.setPhone("+375177896543");
		a5.setStreet("Solnechnaya");
		a5.setCities(Cities.KLETSK);

		Address a6 = new Address();
		a6.setHouseNumber(6);
		a6.setPhone("+375332345678");
		a6.setStreet("Nikiforova");
		a6.setCities(Cities.KOPYL);

		Address a7 = new Address();
		a7.setHouseNumber(7);
		a7.setPhone("+375332345678");
		a7.setStreet("Nikiforova");
		a7.setCities(Cities.KOPYL);

		System.out.println(a6.equals(a7));
		System.out.println("a6.hashCode() = " + a6.hashCode());
		System.out.println("a7.hashCode() = " + a7.hashCode());

		ChiefMedical ch = new ChiefMedical();
		ch.setAge(20);
		ch.setAwards("Nobel prize");
		ch.setFirstName("Ivan");
		ch.setAddress(a1);
		ch.setJobTitle("Chief medical officer");
		ch.setLastName("Ivanov");
		ch.setPersonalRoom(true);
		ch.setPhD(true);
		ch.setSalaryRate(5);
		ch.setSubordinates(5);

		ChiefAccountant ca = new ChiefAccountant();
		ca.setAddress(a2);
		ca.setAge(40);
		ca.setEconomicEducation(true);
		ca.setFirstName("Elena");
		ca.setJobTitle("Chief Accountant Officer");
		ca.setLastName("Novikava");
		ca.setPersonalRoom(true);
		ca.setSalaryRate(3);
		ca.setSubordinates(2);

		GeneralPractice gp = new GeneralPractice();
		gp.setAddress(a3);
		gp.setAge(30);
		gp.setFirstName("Nikolay");
		gp.setJobTitle("Therapist");
		gp.setLastName("Borisov");
		gp.setMedicalExp(10);
		gp.setNightShift(false);
		gp.setSpecialization("therapy");
		gp.setSurgicalPractice(true);

		Surgeon su = new Surgeon();
		su.setAddress(a4);
		su.setAge(34);
		su.setFirstName("Boris");
		su.setJobTitle("Chief surgeon");
		su.setLastName("Kotov");
		su.setMedicalExp(12);
		su.setNightShift(true);
		su.setSpecialization("cardiothoracic surgery");
		su.setTherapeuticPractice(true);

		Janitor ja = new Janitor();
		ja.setAddress(a5);
		ja.setAge(55);
		ja.setFirstName("Valentin");
		ja.setJobTitle("Janitor");
		ja.setLastName("Smirnov");
		ja.setPrivileges(false);
		ja.setRelatedEducation(false);
		ja.setUseInstruments(true);
	
		
		Administration me = new ChiefMedical();
		Administration ac = new ChiefAccountant();
		me.decMaker();
		ac.decMaker();

		System.out.println();

		IEat su1 = new Surgeon();
		IEat gp1 = new GeneralPractice();
		IEat ca1 = new ChiefAccountant();
		IEat cm1 = new ChiefMedical();
		IEat ja1 = new Janitor();

		su1.eat();
		gp1.eat();
		ca1.eat();
		cm1.eat();
		ja1.eat();

		StringBuilder sb = new StringBuilder("Names of all hospital staff: ");
		sb.append(ja.getFirstName()).append(",").append(" ")
				.append(su.getFirstName()).append(",").append(" ").append(gp.getFirstName()).append(",").append(" ")
				.append(ca.getFirstName()).append(",").append(" ").append(ch.getFirstName()).append(".");
		System.out.println(sb.toString());

		StringBuffer sf = new StringBuffer("Surmanes of all hostital staff: ");
		sf.append(ja.getLastName()).append(",").append(" ")
				.append(su.getLastName()).append(",").append(" ").append(gp.getLastName()).append(",").append(" ")
				.append(ca.getLastName()).append(",").append(" ").append(ch.getLastName()).append(".");
		System.out.println(sf.toString());

		System.out.println(StringUtils.substring("stringutils java", 12));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(" "));
		System.out.println("\n");
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isBlank(" "));
		File invoice = new File("src/SDK (Elena Zagrebelnaya).txt");
		{
			try {

				String invoiceText = FileUtils.readFileToString(invoice, "UTF-8");
				System.out.println(invoiceText);
				String invoiceNew = StringUtils.replaceEachRepeatedly(invoiceText, new String[] { ",", "(", ")", ":" },
						new String[] { "", "", "", "", });
				String arr[] = StringUtils.split(StringUtils.uncapitalize(invoiceNew), " ");
				StringBuilder newString = new StringBuilder();
				for (int i = 0; i < arr.length; i++) {
					if (!StringUtils.contains(newString, arr[i])) {
						int numberOfWords = StringUtils.countMatches(invoiceText, arr[i]);
						newString.append(StringUtils.capitalize(arr[i])).append(" repeats ").append(numberOfWords)
								.append(" times ").append("\n");
					}
				}
				System.out.println(newString);
				File resultFile = new File("/src/result.txt");
				FileUtils.writeStringToFile(resultFile, newString.toString(), "UTF-8");
			} catch (IOException e) {
				System.out.println("Can not create new file");
			} finally {
				System.out.println("That's it");
			}

		}
		List<HospitalStaff> arrList = new ArrayList<HospitalStaff>();
		List<HospitalStaff> linkList = new LinkedList<HospitalStaff>();

		long startArrList = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			arrList.add(arrList.size() / 2, new GeneralPractice());
			arrList.remove(arrList.size() / 2);
		}
		long perfomanceArrList = System.currentTimeMillis() - startArrList;

		long startLinkList = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			linkList.add(linkList.size() / 2, new Surgeon());
		}
		long perfomanceLinkList = System.currentTimeMillis() - startLinkList;
		System.out.println("Perfomance of ArrayList: " + perfomanceArrList + "\n" + "Perfomance of LinkedList: "
				+ perfomanceLinkList);

	}
}