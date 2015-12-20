package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	protected NavigationHelper(ApplicationManager manager) {
		super(manager);
			}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
			}

	public void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
			}

	public void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
			}
	
	public void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
			}
	
	public void openCreateContactPage() {
		driver.findElement(By.linkText("add new")).click();
			}

	

}
