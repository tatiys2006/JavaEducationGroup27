package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateGroup {
	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testNonEmptyTestCreation() throws Exception {
		openMainPage();
		gotoGroupPage();
		initNewGroup();
		GroupData group = new GroupData();
		group.groupName = "group Takos";
		group.header = "Header Takos";
		group.footer = "Footer Takos";
		fillGroupForm(group);
		submitGroupForm();
		returnToGroupPage();
	}

	@Test
	public void testEmptyTestCreation() throws Exception {
		openMainPage();
		gotoGroupPage();
		initNewGroup();
		GroupData group = new GroupData("", "", "");
		fillGroupForm(group);
		submitGroupForm();
		returnToGroupPage();
	}

	private void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupForm() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillGroupForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.groupName);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	private void initNewGroup() {
		driver.findElement(By.name("new")).click();
	}

	private void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	private void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub

	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
