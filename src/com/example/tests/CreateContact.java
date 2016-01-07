package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateContact extends TestBase{
	
	@Test
	public void testCreateNotEmptyContact()  throws Exception{
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
				
		//actions
		app.getNavigationHelper().openCreateContactPage();
				
		ContactData contact = new ContactData();
		contact.firstname = "New";
		contact.secondname = "AAQ";
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
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().submitContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
				
		//compare states = passed
		//assertEquals(newList.size(), oldList.size() + 1);
				
		//second compare
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
	@Test
	public void testCreateEmptyContact() throws Exception{
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
						
		//actions
		app.getNavigationHelper().openCreateContactPage();
				
		ContactData contact = new ContactData();
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
		contact.choosedGroup = "[none]";
		contact.secondaryAddress = "";
		contact.secondaryHome = "";
		contact.firstnameSecondname = "&";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().submitContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
						
		//second compare
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
}
