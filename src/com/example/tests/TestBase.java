package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	
	protected static ApplicationManager app;
		
	@BeforeTest
	public void setUp() throws Exception{
		app = new ApplicationManager();
			}

	@AfterTest
	public void tearDown()  throws Exception{
		app.stop();
			}
	
	//options for generate random value to some fields for GROUP
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		//qty of groups, that will changed
		for (int i = 0; i < 5; i++ ){
			GroupData group = new GroupData()
					.withGroupName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
				list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	//options for generate random value to some fields for CONTACT
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		//qty of contacts, that will changed
		for (int i = 0; i < 4; i++ ){
			ContactData contact = new ContactData()
				.withFirstname(generateRandomString())
				.withSecondname(generateRandomString())
				.withMyAddress1("My address")
				.withTelNumberHome("1")
				.withTelNumberMobile("2")
				.withTelNumberWork("3")
				.withEmail1("t@test.com")
				.withEmail2("t2@test.com")
				.withBdayDay("2")
				.withBdayMonth("February")
				.withBdayYear("1900")
				.withChoosedGroup("TakosGroup")
				.withSecondaryAddress("secondary address")
				.withSecondaryHome("Secondary home 4");
			
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		//the 3rd field will empty
		if (rnd.nextInt(3) == 0) {
			return "";	
		} else {
			//add to text random value
			return "test" + rnd.nextInt();
		}
	}
	}
