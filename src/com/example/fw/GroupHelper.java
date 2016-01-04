package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	protected GroupHelper(ApplicationManager manager) {
		super(manager);
			}
		
	public void initNewGroup() {
		click(By.name("new"));
			}

	public void fillGroupForm(GroupData group) {
				type(By.name("group_name"), group.groupName);
				type(By.name("group_header"), group.header);
				type(By.name("group_footer"), group.footer);
					}

	public void submitGroupForm() {
		click(By.name("submit"));
			}
	
	public void returnToGroupPage() {
		click(By.linkText("group page"));
			}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
			}

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
			}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
			}

	public void submitGroupModification() {
		click(By.name("update"));
			}

	public List<GroupData> getGroup() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			//cut some symbols
			group.groupName = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}

}
