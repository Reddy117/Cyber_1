package com.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.base.BaseClass;
import com.bdd.base.OR;

public class TasksPage extends BaseClass{
	
	@FindBy(xpath=OR.tasksLinkx)
	WebElement tasksLink;
	
	@FindBy(xpath=OR.newBtnx)
	WebElement newBtn;
	
	@FindBy(xpath=OR.taskTitlex)
	WebElement taskTitletxt;
	
	@FindBy(xpath=OR.taskDeleteBtnx)
	WebElement dealdeletebtn;
	
	@FindBy(xpath=OR.taskDeleteLinkx)
	WebElement dealDeletelink;
	
	@FindBy(xpath=OR.savebtnx)
	WebElement saveBtn;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createTask(String taskTitle) {
		try {
			tasksLink.click();
			newBtn.click();
			taskTitletxt.sendKeys(taskTitle);
			saveBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
