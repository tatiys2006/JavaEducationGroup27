package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class RemoveSomeContact extends TestBase{
	
	//Edit-> Remove
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContactFromEditPage(ContactData contact){
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
										
		//actions
		app.getContactHelper().deleteContact(index);
		
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
											
		//second compare
		oldListContact.remove(index-1);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
	//Details->Modify->Remove
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContactFromModifyAndEditPage(ContactData contact){
		app.navigateTo().mainPage();
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
												
		//actions
		app.getContactHelper().detailOfContact(index)
								.initModifySomeContact()
								.deleteSomeContact()
								.returnToHomePage();
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
													
		//second compare
		oldListContact.remove(index-1);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
}
}