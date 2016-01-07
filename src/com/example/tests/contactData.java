package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	public String firstnameSecondname;

	// Empty Contact
	public ContactData() {
	}

	// Filled contact
	public ContactData(String firstname, String secondname, String myAddress1, String telNumberHome,
			String telNumberMobile, String telNumberWork, String email1, String email2, String bdayDay,
			String bdayMonth, String bdayYear, String choosedGroup, String secondaryAddress, String secondaryHome, String firstnameSecondname) {
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
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
	
	}


	

