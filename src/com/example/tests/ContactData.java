package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String secondname;
	private String myAddress1;
	private String telNumberHome;
	private String telNumberMobile;
	private String telNumberWork;
	private String email1;
	private String email2;
	private String bdayDay;
	private String bdayMonth;
	private String bdayYear;
	private String choosedGroup;
	private String secondaryAddress;
	private String secondaryHome;
	private String firstnameSecondname;

	// Empty Contact
	public ContactData() {
	}

	// Filled contact
	public ContactData(String firstname, String secondname, String myAddress1, String telNumberHome,
			String telNumberMobile, String telNumberWork, String email1, String email2, String bdayDay,
			String bdayMonth, String bdayYear, String choosedGroup, String secondaryAddress, String secondaryHome, String firstnameSecondname) {
		this.setFirstname(firstname);
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
		this.firstnameSecondname = firstnameSecondname;
	}

	
	@Override
	public String toString() {
//		return "ContactData [firstnameSecondname=" + firstnameSecondname + "]";
		return firstnameSecondname;
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		// result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		// result = prime * result + ((firstname == null) ? 0 :
		// firstname.hashCode());
		// result = prime * result + ((secondname == null) ? 0 :
		// secondname.hashCode());
		// result = prime * result + ((telNumberHome == null) ? 0 :
		// telNumberHome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (getFirstname() == null) {
			if (other.getFirstname() != null)
				return false;
		} else if (!getFirstname().equals(other.getFirstname()))
			return false;
		if (secondname == null) {
			if (other.secondname != null)
				return false;
		} else if (!secondname.equals(other.secondname))
			return false;
		if (firstnameSecondname == null) {
			if (other.firstnameSecondname != null)
				return false;
		} else if (!firstnameSecondname.equals(other.firstnameSecondname))
			return false;
		if (telNumberHome == null) {
			if (other.telNumberHome != null)
				return false;
		} else if (!telNumberHome.equals(other.telNumberHome))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.firstnameSecondname.toLowerCase().compareTo(other.firstnameSecondname.toLowerCase());
			}
	
	//setters (not standard)
	public ContactData withFirstname(String firstname) {
		this.setFirstname(firstname);
		return this;
	}

	public ContactData withSecondname(String secondname) {
		this.secondname = secondname;
		return this;
	}

	public ContactData withMyAddress1(String myAddress1) {
		this.myAddress1 = myAddress1;
		return this;
	}

	public ContactData withTelNumberHome(String telNumberHome) {
		this.telNumberHome = telNumberHome;
		return this;
	}

	public ContactData withTelNumberMobile(String telNumberMobile) {
		this.telNumberMobile = telNumberMobile;
		return this;
	}

	public ContactData withTelNumberWork(String telNumberWork) {
		this.telNumberWork = telNumberWork;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBdayDay(String bdayDay) {
		this.bdayDay = bdayDay;
		return this;
	}

	public ContactData withBdayMonth(String bdayMonth) {
		this.bdayMonth = bdayMonth;
		return this;
	}

	public ContactData withBdayYear(String bdayYear) {
		this.bdayYear = bdayYear;
		return this;
	}

	public ContactData withChoosedGroup(String choosedGroup) {
		this.choosedGroup = choosedGroup;
		return this;
	}

	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}

	public ContactData withSecondaryHome(String secondaryHome) {
		this.secondaryHome = secondaryHome;
		return this;
	}

	//getters
	public String getFirstname() {
		return firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public String getMyAddress1() {
		return myAddress1;
	}

	public String getTelNumberHome() {
		return telNumberHome;
	}

	public String getTelNumberMobile() {
		return telNumberMobile;
	}

	public String getTelNumberWork() {
		return telNumberWork;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBdayDay() {
		return bdayDay;
	}

	public String getBdayMonth() {
		return bdayMonth;
	}

	public String getBdayYear() {
		return bdayYear;
	}

	public String getChoosedGroup() {
		return choosedGroup;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getSecondaryHome() {
		return secondaryHome;
	}

	public String getFirstnameSecondname() {
		return firstnameSecondname;
	}

	//standard setters
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public void setMyAddress1(String myAddress1) {
		this.myAddress1 = myAddress1;
	}

	public void setTelNumberHome(String telNumberHome) {
		this.telNumberHome = telNumberHome;
	}

	public void setTelNumberMobile(String telNumberMobile) {
		this.telNumberMobile = telNumberMobile;
	}

	public void setTelNumberWork(String telNumberWork) {
		this.telNumberWork = telNumberWork;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBdayDay(String bdayDay) {
		this.bdayDay = bdayDay;
	}

	public void setBdayMonth(String bdayMonth) {
		this.bdayMonth = bdayMonth;
	}

	public void setBdayYear(String bdayYear) {
		this.bdayYear = bdayYear;
	}

	public void setChoosedGroup(String choosedGroup) {
		this.choosedGroup = choosedGroup;
	}

	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public void setSecondaryHome(String secondaryHome) {
		this.secondaryHome = secondaryHome;
	}

	public void setFirstnameSecondname(String firstnameSecondname) {
		this.firstnameSecondname = firstnameSecondname;
	}
	
		}




	

