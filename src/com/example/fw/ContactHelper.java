package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	protected ContactHelper(ApplicationManager manager) {
		super(manager);
			}
	
	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.secondname);
		type(By.name("address"), contact.myAddress1);
		type(By.name("home"), contact.telNumberHome);
		type(By.name("mobile"), contact.telNumberMobile);
		type(By.name("work"), contact.telNumberWork);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		//selectByText(By.name("bday"), contact.bdayDay);
		//selectByText(By.name("bmonth"), contact.bdayMonth);
		type(By.name("byear"), contact.bdayYear);
		//selectByText(By.name("new_group"), contact.choosedGroup);
		type(By.name("address2"), contact.secondaryAddress);
		type(By.name("phone2"), contact.secondaryHome);
		type(By.name("firstname"), contact.firstname);
		}
	
	public void submitContactForm() {
		click(By.name("submit"));
	}
	
	//Update button
	public void updateContactForm() {
		click(By.xpath("//input[@value='Update']"));
	}
	
	//Delete button
	public void deleteSomeContact() {
		click(By.xpath("//input[@value='Delete']"));
			}
	//Modify button
	public void initModifySomeContact() {
		click(By.xpath("//input[@value='Modify']"));
			}
	
	//select some contact
	public void selectContactByIndex(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[ + index + ]/td[1]"));
			}

	//icon "Edit"
	public void initContactEdit(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[7]"));
			}
		
	//Icon "Detail"
	public void detailOfContact(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[6]"));
		
			}
}
