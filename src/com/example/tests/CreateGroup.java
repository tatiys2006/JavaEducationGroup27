package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase {
	
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
				
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//actions
		app.getGroupHelper().createGroup(group);
		
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroup();
		
		//second compare
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
