package com.bdd.steps;

import com.bdd.pages.TasksPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class TaskSteps extends TasksPage{

	@Given("^I create task by using \"([^\"]*)\"$")
	public void i_create_task_by_using(String arg1) throws Throwable {
	   createTask(arg1);
	}
}
