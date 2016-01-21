package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

public class CreateContact extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testCreateValidContact(ContactData contact)  throws Exception{
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
				
		//actions
		app.getContactHelper().createContact(contact);
		
				
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
