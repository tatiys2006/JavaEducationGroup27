package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class CreateGroup extends TestBase {
	
	@Test
	public void testNonEmptyTestCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//actions
		app.getGroupHelper().initNewGroup();
		GroupData group = new GroupData();
		group.groupName = "group Takos";
		group.header = "Header Takos";
		group.footer = "Footer Takos";
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

	@Test
	public void testEmptyTestCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//actions	
		app.getGroupHelper().initNewGroup();
		GroupData group = new GroupData("", "", "");
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupForm();
		app.getGroupHelper().returnToGroupPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroup();
		
		//second compare
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
