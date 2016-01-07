package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.tls.SRPTlsClient;
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
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		int i = 2;
		for (WebElement checkbox : checkboxes) {
			
			ContactData contactFromHomeTable = new ContactData();
			contactFromHomeTable.secondname = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+i+"]/td[2]")).getText();
			contactFromHomeTable.firstname = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+i+"]/td[3]")).getText();
			this.controlOfData(contactFromHomeTable);
			contactFromHomeTable.firstnameSecondname.trim();
			contacts.add(contactFromHomeTable);
			i ++;
		}
		return contacts;
	}

	public void setInfoFromContact(ContactData infoFormContact) {
		infoFormContact.firstname = driver.findElement(By.name("firstname")).getAttribute("value");
		infoFormContact.secondname = driver.findElement(By.name("lastname")).getAttribute("value");
		infoFormContact.myAddress1 = driver.findElement(By.name("address")).getText();
		infoFormContact.telNumberHome = driver.findElement(By.name("home")).getAttribute("value");
		infoFormContact.telNumberMobile = driver.findElement(By.name("mobile")).getAttribute("value");
		infoFormContact.telNumberWork = driver.findElement(By.name("work")).getAttribute("value");
		infoFormContact.email1 = driver.findElement(By.name("email")).getAttribute("value");
		infoFormContact.email2 = driver.findElement(By.name("email2")).getAttribute("value");
		infoFormContact.bdayYear = driver.findElement(By.name("byear")).getAttribute("value");
		infoFormContact.secondaryAddress = driver.findElement(By.name("address2")).getText();
		infoFormContact.secondaryHome = driver.findElement(By.name("phone2")).getAttribute("value");
		}

	public void clearContactData(ContactData infoFormContact) {
		infoFormContact.myAddress1 = null;
		infoFormContact.telNumberHome = null;
		infoFormContact.telNumberMobile = null;
		infoFormContact.telNumberWork = null;
		infoFormContact.email1 = null;
		infoFormContact.email2 = null;
		infoFormContact.bdayYear = null;
		infoFormContact.secondaryAddress = null;
		infoFormContact.secondaryHome = null;
		
	}

	public void controlOfData(ContactData contact) {

		if (contact.secondname != null & contact.firstname != null){
			contact.firstnameSecondname = contact.secondname + "&" + contact.firstname;
	
		} else { if (contact.secondname != null & contact.firstname == null){
			contact.firstnameSecondname = contact.secondname;
			
				} else { if (contact.secondname == null & contact.firstname != null){
				contact.firstnameSecondname = contact.firstname;
					} else {
						contact.firstnameSecondname = "";
						}
				}
		}
		
	}

	
}
