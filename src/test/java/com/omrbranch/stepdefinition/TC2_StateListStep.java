package com.omrbranch.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.omrbranch.Pojo.address.StateList;
import com.omrbranch.Pojo.address.StateList_Output_Pojo;
import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;


import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClass {
	Response response;
	
	@Given("User add header for statelist")
	public void user_add_header_for_statelist() {
		given();
		header("accept", "application/json");



	}
	@When("User send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String type) {
		 response = requestType(type, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);

	}

	@Then("User should verify the statelist response message matches {string} and saved stateid")
	public void user_should_verify_the_statelist_response_message_matches_and_saved_stateid(String expStateName) {
		
	StateList_Output_Pojo stateList_Output_pojo = response.as(StateList_Output_Pojo.class);
		
		ArrayList<StateList> data = stateList_Output_pojo.getData();
		
		for (StateList eachStateList : data) {
			String stateName = eachStateList.getName();
			if (stateName.equals(expStateName)) {
				int stateIdNum = eachStateList.getId();
				String stateIdText = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setStateIdText(stateIdText);
				//System.out.println(stateIdNum);
				TC1_LoginStep.globalDatas.getStateIdNum();
				Assert.assertEquals("verify state name", expStateName, stateName);
				break;
				
			}





}
	}
	}
