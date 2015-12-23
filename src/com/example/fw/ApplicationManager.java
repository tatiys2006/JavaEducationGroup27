package com.example.fw;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
	
	private NavigationHelper navigationHelper; 
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
		
	//Start driver
		public ApplicationManager(){
			driver = new FirefoxDriver();
			//driver = new ChromeDriver();
			baseUrl = "http://localhost/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//navigationHelper = new NavigaionHelper(this);
			//groupHelper = new GroupHeplper(this);
			//contactHelper = new ContactHepler(this);
				}
		
		//Stop driver
		public void stop() {
			driver.quit();
			}
	
		
		public NavigationHelper getNavigationHelper(){
			if (navigationHelper == null){
				navigationHelper = new NavigationHelper(this);
			} return navigationHelper;
		}
		
		public GroupHelper getGroupHelper(){
			if (groupHelper == null){
				groupHelper = new GroupHelper(this);
			} return groupHelper;
		}
		
		public ContactHelper getContactHelper(){
			if (contactHelper == null){
				contactHelper = new ContactHelper(this);
			} return contactHelper;
		}	
}
