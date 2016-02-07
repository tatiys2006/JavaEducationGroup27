package com.example.fw;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
	
	private NavigationHelper navigationHelper; 
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
		
	//Start driver
		public ApplicationManager(Properties properties){
			this.properties = properties;
			String browser = properties.getProperty("browser");
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();
			} else if ("ie".equals(browser)){
				File file = new File("IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
			} else if ("chrome".equals(browser)){
				File file = new File("chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
			} else {
				throw new Error("Unsupported browser: " + browser);
			}
			
			
			baseUrl = properties.getProperty("baseUrl");
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl);
			
			//navigationHelper = new NavigaionHelper(this);
			//groupHelper = new GroupHeplper(this);
			//contactHelper = new ContactHepler(this);
				}
		
		//Stop driver
		public void stop() {
			driver.quit();
			}
	
		
		public NavigationHelper navigateTo(){
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
