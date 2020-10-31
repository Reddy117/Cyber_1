package com.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.base.BaseClass;
import com.bdd.base.OR;

public class LoginPage extends BaseClass{

	@FindBy(xpath=OR.uNamex)
	WebElement userNameTxt;
	
	@FindBy(xpath=OR.passWordx)
	WebElement passWrodTxxt;
	
	@FindBy(xpath=OR.signInbtnx)
	WebElement signInbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String uName,String passWord) {
		try {
			userNameTxt.sendKeys(uName);
			passWrodTxxt.sendKeys(passWord);
			signInbtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
