package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class EditContactInfo extends TestBase{
	
	//with "Edit" icon
	@Test(dataProvider = "randomValidContactGenerator")
	public void editSomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
						
		//actions
		app.getContactHelper().initContactEdit(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
							
		//second compare
		oldListContact.remove(index-1);
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
	//через просмотр и модификацию
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
								
		//actions
		app.getContactHelper().detailOfContact(index);
		app.getContactHelper().initModifySomeContact();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().controlOfData(contact);
		app.getContactHelper().clearContactData(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
									
		//second compare
		oldListContact.remove(index-1);
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
}
