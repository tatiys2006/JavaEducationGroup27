package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateContact extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testCreateValidContact(ContactData contact)  throws Exception{
				
		//save old state
		SortedListOf<ContactData> oldListContact = app.getContactHelper().getContact();
				
		//actions
		app.getContactHelper().createContact(contact);
		
		//save new state
		SortedListOf<ContactData> newListContact = app.getContactHelper().getContact();
				
		//compare states = passed
		//assertEquals(newList.size(), oldList.size() + 1);
				
		//second compare
		assertThat(newListContact, equalTo(oldListContact.withAdded(contact)));
	}
	
}
