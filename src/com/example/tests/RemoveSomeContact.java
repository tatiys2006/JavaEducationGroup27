package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class RemoveSomeContact extends TestBase{
	
	//Edit-> Remove
	@Test
	public void deleteSomeContactFromEditPage(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
										
		//actions
		app.getContactHelper().initContactEdit(5);
		app.getContactHelper().deleteSomeContact();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
											
		//second compare
		oldListContact.remove(5);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
	}
	
	//Details->Modify->Remove
	@Test
	public void deleteSomeContactFromModifyAndEditPage(){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<ContactData> oldListContact = app.getContactHelper().getContact();
												
		//actions
		app.getContactHelper().detailOfContact(3);
		app.getContactHelper().initModifySomeContact();
		app.getContactHelper().deleteSomeContact();
		app.getNavigationHelper().returnToHomePage();
		//save new state
		List<ContactData> newListContact = app.getContactHelper().getContact();
													
		//second compare
		oldListContact.remove(3);
		Collections.sort(oldListContact);
		assertEquals(newListContact, oldListContact);
}
}