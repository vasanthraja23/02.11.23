package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.Pojo.address.CityList;
import com.omrbranch.Pojo.address.CityList_Output_Pojo;
import com.omrbranch.Pojo.address.StateList;
import com.omrbranch.Pojo.address.StateList_Output_Pojo;
import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadmanager.PayloadObjectManager;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClass {
	
	
	
	PayloadObjectManager pom = new PayloadObjectManager();
	Response response;
	@Given("User add header for citylist")
	public void user_add_header_for_citylist() {
	
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers); 
		
	}
		
	
	@When("User add request body stateid for get city list")
	public void user_add_request_body_stateid_for_get_city_list() {
		System.out.println(TC1_LoginStep.globalDatas.getStateIdText());

		payLoad(pom.getAddresPayload().getCityListPayLoad(TC1_LoginStep.globalDatas.getStateIdText()));
		 
	}
	@When("User send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String type) {
	
		 response =  requestType(type,Endpoints.CITYLIST);
			int statusCode = getStatusCode(response);
			TC1_LoginStep.globalDatas.setStatuscode(statusCode);
		}
	 
	
	@Then("User should verify the citylist response message matches  {string} and saved cityid")
	public void user_should_verify_the_citylist_response_message_matches_and_saved_cityid(String expCityName) {
		
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> data = cityList_Output_Pojo.getData();
		
		for(CityList eachCityList : data) {
			String cityName = eachCityList.getName();
			if(cityName.equals(expCityName)) {
				int cityId = eachCityList.getId();
				System.out.println(cityId);
				TC1_LoginStep.globalDatas.setCityId(cityId);
				Assert.assertEquals("Verify CityName", expCityName, cityName);
				
			}
		}
	}

}
