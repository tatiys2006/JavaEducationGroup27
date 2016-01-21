package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	protected ContactHelper(ApplicationManager manager) {
		super(manager);
			}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContact() {
			if (cachedContacts == null){
				rebuildCacheContact();
					} 
			return cachedContacts;
				}
	
	private void rebuildCacheContact() {
		SortedListOf<ContactData> cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='maintable']//tr[@name='entry']"));
		for (WebElement row : rows) {
				String firstname = row.findElement(By.xpath(".//td[3]")).getText();
				String secondname = row.findElement(By.xpath(".//td[2]")).getText();
				this.controlOfData(new ContactData().withFirstname(firstname).withSecondname(secondname));
				cachedContacts.add(new ContactData().withFirstname(firstname).withSecondname(secondname));
				}
			}
	
	public ContactHelper createContact(ContactData contact) {
		openCreateContactPage();
		fillContactForm(contact, CREATION);
		controlOfData(contact);
		clearContactData(contact);
		submitContactForm();
		returnToHomePage();	
		rebuildCacheContact();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactEdit(index);
		deleteSomeContact();
		returnToHomePage();
		rebuildCacheContact();
		return this;
	}
	
	public ContactHelper removeWithModifyButton(int index) {
		detailOfContact(index);
		initModifySomeContact();
		deleteSomeContact();
		returnToHomePage();
		rebuildCacheContact();
		return this;
	}
	
	public ContactHelper editContactUseEditButton(ContactData contact, int index) {
		initContactEdit(index);
		fillContactForm(contact, MODIFICATION);
		controlOfData(contact);
		clearContactData(contact);
		updateContactForm();
		returnToHomePage();
		rebuildCacheContact();
		return this;
	}
	
	public ContactHelper editContactUseModificationButton(ContactData contact, int index) {
		detailOfContact(index);
		initModifySomeContact();
		fillContactForm(contact, MODIFICATION);
		controlOfData(contact);
		clearContactData(contact);
		updateContactForm();
		returnToHomePage();
		rebuildCacheContact();
		return this;
	}
	
	
//----------------------------------------------------------------------------------------
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getSecondname());
		type(By.name("address"), contact.getMyAddress1());
		type(By.name("home"), contact.getTelNumberHome());
		type(By.name("mobile"), contact.getTelNumberMobile());
		type(By.name("work"), contact.getTelNumberWork());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		//selectByText(By.name("bday"), contact.getBdayDay());
		//selectByText(By.name("bmonth"), contact.getBdayMonth());
		type(By.name("byear"), contact.getBdayYear());
		if (formType == CREATION ){
		//selectByText(By.name("new_group"), contact.choosedGroup);
		} else {
			if (driver.findElements(By.name("new_group")).size() !=0){
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getSecondaryAddress());
		type(By.name("phone2"), contact.getSecondaryHome());
		return this;
		}
	
	public ContactHelper submitContactForm() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	
	//Update button
	public ContactHelper updateContactForm() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	//Delete button
	public ContactHelper deleteSomeContact() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
			}
	
	//Modify button
	public ContactHelper initModifySomeContact() {
		click(By.xpath("//input[@value='Modify']"));
		return this;
			}
	
	//select some contact
	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[1]"));
		return this;
			}

	//icon "Edit"
	public ContactHelper initContactEdit(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]"));
		return this;
			}
		
	//Icon "Detail"
	public ContactHelper detailOfContact(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[6]"));
		return this;
			}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
			}
	
	public ContactHelper openCreateContactPage() {
		click(By.linkText("add new"));
		return this;
			}

	

	public void setInfoFromContact(ContactData infoFormContact) {
		infoFormContact.setFirstname(driver.findElement(By.name("firstname")).getAttribute("value"));
		infoFormContact.setSecondname(driver.findElement(By.name("lastname")).getAttribute("value"));
		infoFormContact.setMyAddress1(driver.findElement(By.name("address")).getText());
		infoFormContact.setTelNumberHome(driver.findElement(By.name("home")).getAttribute("value"));
		infoFormContact.setTelNumberMobile(driver.findElement(By.name("mobile")).getAttribute("value"));
		infoFormContact.setTelNumberWork(driver.findElement(By.name("work")).getAttribute("value"));
		infoFormContact.setEmail1(driver.findElement(By.name("email")).getAttribute("value"));
		infoFormContact.setEmail2(driver.findElement(By.name("email2")).getAttribute("value"));
		infoFormContact.setBdayYear(driver.findElement(By.name("byear")).getAttribute("value"));
		infoFormContact.setSecondaryAddress(driver.findElement(By.name("address2")).getText());
		infoFormContact.setSecondaryHome(driver.findElement(By.name("phone2")).getAttribute("value"));
		}

	public ContactHelper clearContactData(ContactData infoFormContact) {
		infoFormContact.setMyAddress1(null);
		infoFormContact.setTelNumberHome(null);
		infoFormContact.setTelNumberMobile(null);
		infoFormContact.setTelNumberWork(null);
		infoFormContact.setEmail1(null);
		infoFormContact.setEmail2(null);
		infoFormContact.setBdayYear(null);
		infoFormContact.setSecondaryAddress(null);
		infoFormContact.setSecondaryHome(null);
		return this;
	}

	public ContactHelper controlOfData(ContactData contact) {

		if (contact.getSecondname() != null & contact.getFirstname() != null){
			contact.setFirstnameSecondname(contact.getSecondname() + " " + contact.getFirstname());
	
		} else { if (contact.getSecondname() != null & contact.getFirstname() == null){
			contact.setFirstnameSecondname(contact.getSecondname());
			
				} else { if (contact.getSecondname() == null & contact.getFirstname() != null){
				contact.setFirstnameSecondname(contact.getFirstname());
					} else {
						contact.setFirstnameSecondname("");
						}
				}
		} 
		return this;
	}

	

}
