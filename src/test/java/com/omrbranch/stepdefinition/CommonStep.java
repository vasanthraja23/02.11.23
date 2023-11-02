package com.omrbranch.stepdefinition;



import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {
	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expstatuscode) {
		int actstatuscode = TC1_LoginStep.globalDatas.getStatuscode();
		Assert.assertEquals("Verify StatusCode",expstatuscode, actstatuscode);
	 
	}

}
