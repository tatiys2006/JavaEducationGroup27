package com.example.tests;

import org.testng.annotations.Test;

public class CreateContact extends TestBase{
	
	@Test
	public void testCreateNotEmptyContact() throws Exception {
		openMainPage();
		openCreateContactPage();
				
		contactData contact = new contactData();
		contact.firstname = "Takos";
		contact.secondname = "Test";
		contact.myAddress1 = "My address";
		contact.telNumberHome = "1";
		contact.telNumberMobile = "2";
		contact.telNumberWork = "3";
		contact.email1 = "t@test.com";
		contact.email2 = "t2@test.com";
		contact.bdayDay = "2";
		contact.bdayMonth = "February";
		contact.bdayYear = "1900";
		contact.choosedGroup = "TakosGroup";
		contact.secondaryAddress = "secondary address";
		contact.secondaryHome = "Secondary home 4";
		fillContactForm(contact);
		submitContactForm();
		returnToHomePage();
	}
	@Test
	public void testCreateEmptyContact() throws Exception {
		openMainPage();
		openCreateContactPage();
				
		contactData contact = new contactData();
		contact.firstname = "";
		contact.secondname = "";
		contact.myAddress1 = "";
		contact.telNumberHome = "";
		contact.telNumberMobile = "";
		contact.telNumberWork = "";
		contact.email1 = "";
		contact.email2 = "";
		contact.bdayDay = "-";
		contact.bdayMonth = "-";
		contact.bdayYear = "";
		contact.choosedGroup = "";
		contact.secondaryAddress = "";
		contact.secondaryHome = "";
		fillContactForm(contact);
		submitContactForm();
		returnToHomePage();
	}
	
}
