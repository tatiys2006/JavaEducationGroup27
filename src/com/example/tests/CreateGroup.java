package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase {
	@Test
	public void testNonEmptyTestCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initNewGroup();
		GroupData group = new GroupData();
		group.groupName = "group Takos";
		group.header = "Header Takos";
		group.footer = "Footer Takos";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupForm();
		app.getNavigationHelper().returnToGroupPage();
	}

	@Test
	public void testEmptyTestCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initNewGroup();
		GroupData group = new GroupData(" ", " ", " ");
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupForm();
		app.getNavigationHelper().returnToGroupPage();
	}
}
