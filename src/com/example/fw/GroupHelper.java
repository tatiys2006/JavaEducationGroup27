package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	protected GroupHelper(ApplicationManager manager) {
		super(manager);
			}
	
	
	public void initNewGroup() {
		driver.findElement(By.name("new")).click();
			}

	public void fillGroupForm(GroupData group) {
				By locator = By.name("group_name");
				String text = group.groupName;
				driver.findElement(locator).clear();
				driver.findElement(locator).sendKeys(text);
				driver.findElement(By.name("group_header")).clear();
				driver.findElement(By.name("group_header")).sendKeys(group.header);
				driver.findElement(By.name("group_footer")).clear();
				driver.findElement(By.name("group_footer")).sendKeys(group.footer);
			}


	private void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void submitGroupForm() {
				driver.findElement(By.name("submit")).click();
			}

}
