package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EditContactInfo extends TestBase{
	
	//with "Edit" icon
	@Test
	public void editSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
						
		//actions
		app.getContactHelper().initContactEdit(5);
		
		
		ContactData contact = new ContactData();
		app.getContactHelper().setInfoFromContact(contact);
		
		contact.firstname = "new-firstname2";
			
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
							
		//second compare
		oldListContact.remove(4);
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
	//через просмотр и модификацию
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
								
		//actions
		app.getContactHelper().detailOfContact(3);
		app.getContactHelper().initModifySomeContact();
		ContactData contact = new ContactData();
		app.getContactHelper().setInfoFromContact(contact);
		
		contact.firstname = "Modify test";
			
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
									
		//second compare
		oldListContact.remove(2);
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
}
