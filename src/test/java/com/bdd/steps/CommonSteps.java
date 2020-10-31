package com.bdd.steps;

import cucumber.api.Scenario;
import com.bdd.base.BaseClass;
import com.bdd.pages.LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonSteps extends BaseClass{
	
	public CommonSteps() {
		super();
	}
	
	Scenario sce;
//	GlobalCommonObjects globalComPageObj = new GlobalCommonObjects(dr);
	@Before
	public void beforeHook(Scenario scenario) throws InterruptedException {
	     	this.sce = scenario;
	     	
	  
	}

	@Given("^I go to freecrm website$")
	public void i_go_to_freecrm_website() throws Throwable {
		initialize("chrome");
	}
	
	@Given("I login to the website")
	public void login() {
		System.out.println(prop.getProperty("uName"));
		System.out.println(prop.getProperty("passWord"));
		new LoginPage().doLogin(prop.getProperty("uName"), prop.getProperty("passWord"));
	}
	

	@Given("^User reads test data for \"([^\"]*)\"$")
	public void user_reads_test_data_for(String arg1) throws Throwable {
		readTestDataFromExcel(arg1);
	}
}
