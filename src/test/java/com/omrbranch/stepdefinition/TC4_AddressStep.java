package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.junit.Assert;

import com.omrbranch.Pojo.address.AddAddress_Output_Pojo;
import com.omrbranch.Pojo.address.AddressList;
import com.omrbranch.Pojo.address.DeleteAddress_Output_Pojo;
import com.omrbranch.Pojo.address.GetAddress_Output_Pojo;
import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadmanager.PayloadObjectManager;


import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass{
	 PayloadObjectManager pom = new PayloadObjectManager();
	 Response response;


	@Given("User add header and Bearer authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		
		Headers headers = new Headers(lstHeader);
		addHeaders(headers); 
		
	  
	}
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String first_name,String last_name,String mobile,String apartment,String state,String city,String countryId,String zipcode,String address,String address_type) {
	int countryIdNum = Integer.parseInt(countryId);
//	payLoad(pom.getAddresPayload().addAddress(first_name, last_name, mobile, apartment, state, city, countryIdNum, zipcode, address, address_type));
	
	 payLoad(pom.getAddresPayload().addAddress(first_name, last_name, mobile, apartment, TC1_LoginStep.globalDatas.getStateIdNum(), TC1_LoginStep.globalDatas.getCityId(), countryIdNum, zipcode, address, address_type));
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String type) {
		response = requestType(type, Endpoints.ADDADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	   
	}
	
	@Then("User should verify the addUserAddress response message matches {string}")
	public void user_should_verify_the_add_user_address_response_message_matches(String expAddAddressSuccessMsg) {
		AddAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(expAddAddressSuccessMsg, message,"Verify Address Added Successfully");
		
	}

	
	@Given("User add request body for add update address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_update_address_and(String address_id,String first_name,String last_name,String mobile,String apartment,int state,int city,int country,String zipcode,String address,String address_type) {
		 payLoad(pom.getAddresPayload().updateUser(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type));

	}
	@Given("User send {string} request for updateAddress endpoint")
	public void user_send_request_for_update_address_endpoint(String type) {
		response = requestType(type, Endpoints.UPDATEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	
	@Then("User should verify the updateUserAddress response message matches {string}")
	public void user_should_verify_the_update_user_address_response_message_matches(String expUpdateAddessMsg) {
		AddAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		String updateAddress = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(expUpdateAddessMsg, updateAddress,"Verify Updated Address Successfully");
	 
	   
	}
	

	@Given("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String type) {
		response = requestType(type,Endpoints.GETADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	
	@Then("User should verify the getUserAddress response message matches {string}")
	public void user_should_verify_the_get_user_address_response_message_matches(String expUser) {
		GetAddress_Output_Pojo getUserAddress_Output_Pojo=response.as(GetAddress_Output_Pojo.class);
		ArrayList<AddressList> data = getUserAddress_Output_Pojo.getData();
		for( AddressList eachGetUserAddressList : data) {
			String first_name = eachGetUserAddressList.getFirst_name();
			if(first_name.equals(expUser)) {
				String address = eachGetUserAddressList.getAddress();
				TC1_LoginStep.globalDatas.setAddress(address);
				Assert.assertEquals(address, expUser,"Verify GetUserAddress");
				break;
	}



		 }
	}



	@Given("User send {string} request for delete endpoint")
	public void user_send_request_for_delete_endpoint(String type) {
		response = requestType(type,Endpoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	
	}

	@Then("User should verify the delete response message matches {string}")
	public void user_should_verify_the_delete_response_message_matches(String expDeleteMsg) {
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddress_Output_Pojo.getMessage();
	    Assert.assertEquals(message, expDeleteMsg,"Verify Address deleted successfully" );
	    
	}



}
