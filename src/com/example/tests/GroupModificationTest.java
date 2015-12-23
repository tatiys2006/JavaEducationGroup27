package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupName = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}

}
