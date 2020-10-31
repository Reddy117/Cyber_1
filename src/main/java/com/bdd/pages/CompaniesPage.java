package com.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.base.BaseClass;
import com.bdd.base.OR;

public class CompaniesPage extends BaseClass{
	
	@FindBy(xpath=OR.companiesLinkx)
	WebElement companiesLink;
	
	@FindBy(xpath=OR.newBtnx)
	WebElement newBtn;
	
	@FindBy(xpath=OR.companyNamex)
	WebElement companyNameTxt;
	
	@FindBy(xpath=OR.companyWebSitex)
	WebElement companyWebSiteTxt;
	
	@FindBy(xpath=OR.Addressx)
	WebElement addressTxt;
	
	@FindBy(xpath=OR.cittyx)
	WebElement cityTxt;
	
	@FindBy(xpath=OR.Statex)
	WebElement stateTxt;
	
	@FindBy(xpath=OR.zipx)
	WebElement zipTxt;
	
	@FindBy(xpath=OR.savebtnx)
	WebElement savebtn;
	
	@FindBy(xpath=OR.settingsIConbtn)
	WebElement settingbtn;
	
	@FindBy(xpath=OR.logOutbtn)
	WebElement logOutbtn;
	
	@FindBy(xpath=OR.countrydivX)
	WebElement conutryDiv;
	
	@FindBy(xpath=OR.countryboxPath)
	WebElement conutrybox;
	
	@FindBy(xpath=OR.deleteBtnx)
	WebElement deletebtn;
	
	@FindBy(xpath=OR.deleteBtn1x)
	WebElement deletebtn1;
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createCompany() {
		try {
			companiesLink.click();
			newBtn.click();
			companyNameTxt.sendKeys(testDataMap.get("CompanyName"));
			companyWebSiteTxt.sendKeys(testDataMap.get("Web"));
			addressTxt.sendKeys(testDataMap.get("Address"));
			cityTxt.sendKeys(testDataMap.get("City"));
			stateTxt.sendKeys(testDataMap.get("State"));
			zipTxt.sendKeys(testDataMap.get("Zip"));
			selectCountry(testDataMap.get("Country"));
			savebtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectCountry(String countryName) {
		
		conutryDiv.click();
		selectDropDownLooklike(conutrybox, countryName);
	}
	
	public void deleteCompany() {
		try {
			companiesLink.click();
			deletebtn.click();
			deletebtn1.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {
			settingbtn.click();
			logOutbtn.click();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
