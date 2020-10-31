package com.bdd.steps;

import com.bdd.pages.CompaniesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

	public class CompaniesSteps extends CompaniesPage{

	/*@Given("^I created new company by entering all mandatory fields$")
	public void i_created_new_company_by_entering_all_mandatory_fields() throws Throwable {
		System.out.println("coming");
	    createCompany("", "", "", "", "", "", "");
	}*/
	
	@Given("^I created new company")
	public void i_created_new_company_using_and_and_and_and() throws Throwable {
		createCompany();
	}

	@Then("^I validated new company$")
	public void i_validated_new_company() throws Throwable {
	  
	}

	@When("^I click on deletebutton$")
	public void i_click_on_deletebutton() throws Throwable {
	   deleteCompany();
	}

	@Then("^Company should be deleted\\.$")
	public void company_should_be_deleted() throws Throwable {
	    
	}
	
	@When("I Delete Compnay")
	public void deleteCom() {
		deleteCompany();
	}
	
	@Then("Company should be removed")
	public void verifyCompanyDeleted() {
		
	}
	


}
