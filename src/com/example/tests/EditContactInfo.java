package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class EditContactInfo extends TestBase{
	
	//with "Edit" icon
	@Test(dataProvider = "randomValidContactGenerator")
	public void editSomeContact(ContactData contact){
				
		//save old state
		SortedListOf<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
						
		//actions
		app.getContactHelper().editContactUseEditButton(contact, index);
		
		
		//save new state
		SortedListOf<ContactData> newListContact = app.getContactHelper().getContact();
							
		//second compare
				
		assertThat(newListContact, equalTo(oldListContact.without(index-1).withAdded(contact)));
	}
	
	//через просмотр и модификацию
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		
		//save old state
		SortedListOf<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
								
		//actions
		app.getContactHelper().editContactUseModificationButton(contact, index);
		
		
		//save new state
		SortedListOf<ContactData> newListContact = app.getContactHelper().getContact();
									
		//second compare
		assertThat(newListContact, equalTo(oldListContact.without(index-1).withAdded(contact)));
	}
	
}
