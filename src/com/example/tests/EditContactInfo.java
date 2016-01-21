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
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
						
		//actions
		app.getContactHelper().editContactUseEditButton(contact, index);
		
		
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
		app.navigateTo().mainPage();
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
								
		//actions
		app.getContactHelper().editContactUseModificationButton(contact, index);
		
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
									
		//second compare
		oldListContact.remove(index-1);
		oldListContact.add(contact);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
}
