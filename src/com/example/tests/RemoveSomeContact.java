package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class RemoveSomeContact extends TestBase{
	
	//Edit-> Remove
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContactFromEditPage(ContactData contact){
				
		//save old state
		SortedListOf<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
										
		//actions
		app.getContactHelper().deleteContact(index);
		
		
		//save new state
		SortedListOf<ContactData> newListContact = app.getContactHelper().getContact();
											
		//second compare
		assertThat(newListContact, equalTo(oldListContact.without(index-1)));
		
	}
	
	//Details->Modify->Remove
	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContactFromModifyAndEditPage(ContactData contact){
		
		//save old state
		SortedListOf<ContactData> oldListContact = app.getContactHelper().getContact();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldListContact.size()-1);
		if (index == 0){
			index = 1;
		}
												
		//actions
		app.getContactHelper().removeWithModifyButton(index);
		
		//save new state
		SortedListOf<ContactData> newListContact = app.getContactHelper().getContact();
													
		//second compare
		assertThat(newListContact, equalTo(oldListContact.without(index-1)));
		
}
}