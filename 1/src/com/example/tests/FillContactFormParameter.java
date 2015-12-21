package com.example.tests;

public class FillContactFormParameter {
	public String firstname;
	public String secondname;
	public String myAddress1;
	public String telNumberHome;
	public String telNumberMobile;
	public String telNumberWork;
	public String email1;
	public String email2;
	public String bdayDay;
	public String bdayMonth;
	public String bdayYear;
	public String choosedGroup;
	public String secondaryAddress;
	public String secondaryHome;

	public FillContactFormParameter(String firstname, String secondname, String myAddress1, String telNumberHome,
			String telNumberMobile, String telNumberWork, String email1, String email2, String bdayDay,
			String bdayMonth, String bdayYear, String choosedGroup, String secondaryAddress, String secondaryHome) {
		this.firstname = firstname;
		this.secondname = secondname;
		this.myAddress1 = myAddress1;
		this.telNumberHome = telNumberHome;
		this.telNumberMobile = telNumberMobile;
		this.telNumberWork = telNumberWork;
		this.email1 = email1;
		this.email2 = email2;
		this.bdayDay = bdayDay;
		this.bdayMonth = bdayMonth;
		this.bdayYear = bdayYear;
		this.choosedGroup = choosedGroup;
		this.secondaryAddress = secondaryAddress;
		this.secondaryHome = secondaryHome;
	}
}