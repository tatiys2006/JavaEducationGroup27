package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateContact extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
//		return wrapContactsForContactProvider(loadContactsFromCsvFile(new File("contacts.txt") )).iterator();
		return wrapContactsForContactProvider(loadContactsFromXmlFile(new File("contacts.xml") )).iterator();
	}
	
	
	//	@Test(dataProvider = "randomValidContactGenerator")
	@Test(dataProvider = "contactsFromFile")

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
