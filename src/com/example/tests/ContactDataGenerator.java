package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3){
		System.out.println("Please specify parameters for Contacts: <amount of test data> <file> <format>");
		return;
		}
		
		int amountContact = Integer.parseInt(args[0]);
		File fileContacts = new File(args[1]);
		String formatContacts = args[2];
		
		if (fileContacts.exists()){
			System.out.println("File exists, please, remove it manually:" + fileContacts);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amountContact);
		if ("csv".equals(formatContacts)) {
			saveContactsToCsvFile(contacts, fileContacts);
		} else if ("xml".equals(formatContacts)) {
			saveContactsToXmlFile(contacts, fileContacts);
		} else {
			System.out.println("unknown format " + formatContacts);
			return;
		}
		
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File fileContacts) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(fileContacts);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File fileContacts) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(fileContacts);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File fileContacts) throws IOException {
		FileWriter writer = new FileWriter(fileContacts);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getSecondname() + ","  + 
						contact.getMyAddress1() + "," + contact.getTelNumberHome() + "," + 
						contact.getTelNumberMobile() + "," +contact.getTelNumberWork() + "," +
						contact.getEmail1() + "," + contact.getEmail2() + "," + 
						contact.getBdayDay() + "," + contact.getBdayMonth() + "," +
						contact.getBdayYear() + "," + contact.getChoosedGroup() + "," +
						contact.getSecondaryAddress() + "," + contact.getSecondaryHome() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amountContact) {
		List<ContactData> contactList = new ArrayList<ContactData>();
		
		//qty of groups, that will changed
		for (int i = 0; i < amountContact; i++ ){
			ContactData contact = new ContactData()
					.withFirstname(generateRandomString())
					.withSecondname(generateRandomString())
					.withMyAddress1("My address")
					.withTelNumberHome("1")
					.withTelNumberMobile("2")
					.withTelNumberWork("3")
					.withEmail1("t@test.com")
					.withEmail2("t2@test.com")
					.withBdayDay("2")
					.withBdayMonth("February")
					.withBdayYear("1900")
					.withChoosedGroup("TakosGroup")
					.withSecondaryAddress("secondary address")
					.withSecondaryHome("Secondary home 4");
			contactList.add(contact);
		}
		return contactList;
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		//the 3rd field will empty
		if (rnd.nextInt(3) == 0) {
			return "";	
		} else {
			//add to text random value
			return "testContact" + rnd.nextInt(16);
		}
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File fileContacts) throws IOException {
		List<ContactData> contactList = new ArrayList<ContactData>();
		FileReader reader = new FileReader(fileContacts);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withFirstname(part[0])
					.withSecondname(part[1])
					.withMyAddress1(part[2])
					.withTelNumberHome(part[3])
					.withTelNumberMobile(part[4])
					.withTelNumberWork(part[5])
					.withEmail1(part[6])
					.withEmail2(part[7])
					.withBdayDay(part[8])
					.withBdayMonth(part[9])
					.withBdayYear(part[10])
					.withChoosedGroup(part[11])
					.withSecondaryAddress(part[12])
					.withSecondaryHome(part[13]);
			contactList.add(contact);
			line = bufferedReader.readLine();
			
		}
		bufferedReader.close();
		return contactList;
	}
}
