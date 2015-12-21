package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.contactData;

public class ContactHelper extends HelperBase{

	protected ContactHelper(ApplicationManager manager) {
		super(manager);
			}

	public void fillContactForm(contactData contact) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contact.secondname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contact.myAddress1);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contact.telNumberHome);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contact.telNumberMobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contact.telNumberWork);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contact.email1);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contact.email2);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.bdayDay);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.bdayMonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contact.bdayYear);
		new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.choosedGroup);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contact.secondaryAddress);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contact.secondaryHome);
	}

	public void submitContactForm() {
		driver.findElement(By.name("submit")).click();
	}

}
