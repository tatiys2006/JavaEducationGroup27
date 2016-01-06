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
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		//список наборов обьектов
		List<Object[]> list = new ArrayList<Object[]>();
		
		//создаем 5 новых групп
		for (int i = 0; i < 5; i++ ){
			GroupData group = new GroupData();
			group.groupName = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();	
			
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		//каждое 3 будет оставаться пустым
		if (rnd.nextInt(3) == 0) {
			return "";	
		} else {
			//добавляем к имени случайное число
			return "test" + rnd.nextInt();
		}
	}
	}
