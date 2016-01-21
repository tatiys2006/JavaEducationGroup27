package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateGroup extends TestBase {
	
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
				
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//actions
		app.getGroupHelper().createGroup(group);
		
		
		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroup();
		
		//second compare
		assertThat(newList, equalTo(oldList.withAdded(group)));
		
	}
}
