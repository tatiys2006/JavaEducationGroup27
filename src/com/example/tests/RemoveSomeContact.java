package com.example.tests;

import org.testng.annotations.Test;

public class RemoveSomeContact extends TestBase{
	
	//Edit-> Remove
	@Test
	public void deleteSomeContactFromEditPage(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(5);
		app.getContactHelper().deleteSomeContact();
		app.getNavigationHelper().returnToHomePage();
	}
	
	//Details->Modify->Remove
	@Test
	public void deleteSomeContactFromModifyAndEditPage(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().detailOfContact(3);
		app.getContactHelper().initModifySomeContact();
		app.getContactHelper().deleteSomeContact();
		app.getNavigationHelper().returnToHomePage();
}
}