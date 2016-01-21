package com.example.tests;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateGroup extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}
	
	
	

	@Test(dataProvider = "groupsFromFile")
	//randomValidGroupGenerator
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
