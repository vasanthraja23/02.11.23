package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;



import org.junit.Assert;

import com.omrbranch.Pojo.login.Login_Output_Pojo;
import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalDatas;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass{
	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();
	

	@Given("User add header")
	public void user_add_header() {
		given();
		header("accept","application/json"); 
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addBasicAuthentication(getPropertyFileValue("username"), getPropertyFileValue("password"));

	}
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String type) {
		response = requestType(type, Endpoints.LOGIN);
		int statusCode = getStatusCode(response);
		globalDatas.setStatuscode(statusCode);
	   
	}
	
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void user_should_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String expfirstname) {
	Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
	String first_name = login_Output_Pojo.getData().getFirst_name();
	Assert.assertEquals("Verify firstname", expfirstname, first_name);
	}




}
