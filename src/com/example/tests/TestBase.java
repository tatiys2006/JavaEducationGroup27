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
		//������ ������� ��������
		List<Object[]> list = new ArrayList<Object[]>();
		
		//������� 5 ����� �����
		for (int i = 0; i < 5; i++ ){
			GroupData group = new GroupData();
			group.groupName = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();	
			
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		//������ ������� ��������
		List<Object[]> list = new ArrayList<Object[]>();
		
		//qty of contacts
		for (int i = 0; i < 4; i++ ){
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString();
			contact.secondname = generateRandomString();
			contact.myAddress1 = "My address";
			contact.telNumberHome = "1";
			contact.telNumberMobile = "2";
			contact.telNumberWork = "3";
			contact.email1 = "t@test.com";
			contact.email2 = "t2@test.com";
			contact.bdayDay = "2";
			contact.bdayMonth = "February";
			contact.bdayYear = "1900";
			contact.choosedGroup = "TakosGroup";
			contact.secondaryAddress = "secondary address";
			contact.secondaryHome = "Secondary home 4";
			
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		//������ 3 ����� ���������� ������
		if (rnd.nextInt(3) == 0) {
			return "";	
		} else {
			//��������� � ����� ��������� �����
			return "test" + rnd.nextInt();
		}
	}
	}
