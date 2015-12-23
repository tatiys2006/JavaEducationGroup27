package com.example.tests;

import org.testng.annotations.Test;

public class EditContactInfo extends TestBase{
	
	//with "Edit" icon
	@Test
	public void editSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(3);
		ContactData contact = new ContactData();
		contact.firstname = "new firstname (Edit)";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
	}
	
	//через просмотр и модификацию
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().detailOfContact(2);
		app.getContactHelper().initModifySomeContact();
		ContactData contact = new ContactData();
		contact.firstname = "new firstname2 (Modify)";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContactForm();
		app.getNavigationHelper().returnToHomePage();
	}
	
}
