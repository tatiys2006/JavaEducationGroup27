package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTest extends TestBase{

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
				
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroup();
		
		//создаем генератор случайных чисел для удаления случайной группы
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
						
		//actions
		app.getGroupHelper().modifyGroup(index, group);
				
		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroup();
						
		//compare
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		}
}
