package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase {
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
}
