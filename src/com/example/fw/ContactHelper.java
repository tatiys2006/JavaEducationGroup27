package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[1]"));
			}

	//icon "Edit"
	public void initContactEdit(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]"));
			}
		
	//Icon "Detail"
	public void detailOfContact(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[6]"));
		
			}

	public List<ContactData> getContact() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rowsOfTable = driver.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
		for (WebElement rowOfTable : rowsOfTable) {
			ContactData contact = new ContactData();
			String title = rowOfTable.getAttribute("title");
			contact.secondname = rowOfTable.findElement(By.xpath("td[2]")).getText();
			contact.firstname = rowOfTable.findElement(By.xpath("td[3]")).getText();
			//cut some symbols
			contact.firstnameSecondname = title.substring("Select (".length(), title.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
		
		
		/*List<WebElement> rowsOfTable = driver.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
		for (WebElement rowOfTable : rowsOfTable) {
			ContactData contact = new ContactData();
			contact.secondname = rowOfTable.findElement(By.xpath("td[2]")).getText();
			contact.firstname = rowOfTable.findElement(By.xpath("td[3]")).getText();
			contact.email1 = rowOfTable.findElement(By.xpath("td[4]")).getText();
			contact.telNumberHome = rowOfTable.findElement(By.xpath("td[5]")).getText();
			
			contacts.add(contact);
		}
		return contacts;*/
	}
}
