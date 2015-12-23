package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	protected NavigationHelper(ApplicationManager manager) {
		super(manager);
			}

	public void openMainPage() {
		driver.get(manager.baseUrl + "addressbookv4.1.4/");
			}

	public void gotoGroupPage() {
		click(By.linkText("groups"));
			}
	
	public void returnToHomePage() {
		click(By.linkText("home page"));
			}
	
	public void openCreateContactPage() {
		click(By.linkText("add new"));
			}
}
