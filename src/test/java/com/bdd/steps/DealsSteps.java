package com.bdd.steps;

import com.bdd.pages.DealsPage;

import cucumber.api.java.en.Given;

public class DealsSteps extends DealsPage{

	@Given("^Create deal using \"([^\"]*)\"$")
	public void create_deal_using(String arg1) throws Throwable {
	   createDeal(arg1);
	}
	
	@Given("I Create deal")
	public void ccreateDeal() {
		createDeal();
	}
}
