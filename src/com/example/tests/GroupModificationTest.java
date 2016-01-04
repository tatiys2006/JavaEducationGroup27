package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroup();
						
		//actions
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.groupName = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroup();
						
		//compare
		oldList.remove(0);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
