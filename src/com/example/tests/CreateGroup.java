package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase {
	
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//actions
		app.getGroupHelper().initNewGroup();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupForm();
		app.getGroupHelper().returnToGroupPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroup();
		
		//compare states
		//assertEquals(newList.size(), oldList.size() + 1);
		
		//second compare
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
