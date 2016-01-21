package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	protected NavigationHelper(ApplicationManager manager) {
		super(manager);
			}

	public void mainPage() {
		if (! onMainPage()){
			click(By.linkText("home"));
		
			}
		}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	public void groupPage() {
		if (! onGroupsPage()){
			click(By.linkText("groups"));	
		}
	}
	
	private boolean onGroupsPage() {
		String currentUrl = driver.getCurrentUrl();
		driver.findElements(By.name("new"));
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size() > 0){
			return true;
		} else {
		return false;
		}
	}

	
}
