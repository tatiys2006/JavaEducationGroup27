package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateContact extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testCreateValidContact(ContactData contact)  throws Exception{
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
				
		//actions
		app.getNavigationHelper().openCreateContactPage();
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
	
}
