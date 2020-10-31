package com.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.base.BaseClass;
import com.bdd.base.OR;

public class DealsPage extends BaseClass{
	@FindBy(xpath=OR.dealsLinkx)
	WebElement dealsLnk;
	
	@FindBy(xpath=OR.newBtnx)
	WebElement newBtn;
	
	@FindBy(xpath=OR.dealTitlex)
	WebElement dealTitletxt;
	
	@FindBy(xpath=OR.dealdeleteImgx)
	WebElement dealdeleteimg;
	
	@FindBy(xpath=OR.dealDeleteBtnx)
	WebElement dealDeleteBtn;
	
	@FindBy(xpath=OR.savebtnx)
	WebElement saveBtn;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createDeal(String dealTitle)
	{
		try {
			dealsLnk.click();
			newBtn.click();
			dealTitletxt.sendKeys(dealTitle);
			saveBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createDeal()
	{
		try {
			dealsLnk.click();
			newBtn.click();
			dealTitletxt.sendKeys(testDataMap.get("DealTitle"));
			saveBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDeal() {
		try {
			dealsLnk.click();
			dealdeleteimg.click();
			dealDeleteBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
