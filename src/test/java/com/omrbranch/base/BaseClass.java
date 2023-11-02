package com.omrbranch.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification reqSpec;
	public static Response response;

	public  static void given() {
		reqSpec = RestAssured.given();

	}

	public static void payLoad(Object object) {
		reqSpec = reqSpec.body(object);
		

	}

	public static void header(String Key,String Value) {
		reqSpec = reqSpec.header(Key, Value);
		
	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
		

	}
	public static void addBasicAuthentication(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);

	}
	public static void pathParam(String Key,Object Value) {
		reqSpec.pathParam(Key, Value);

	}

	public void queryParam(String parameterName,Object Value) {
		reqSpec.queryParam(parameterName, Value);
	}


	public Response requestType(String key, String value) {
		 response = null;
		//Response response = null;
		switch (key) {
		case "GET":
			 response = reqSpec.get(value);
			break;
		case "POST":
			 response = reqSpec.post(value);
			 break;
		case "PUT":
			response = reqSpec.put(value);
			break;
		case "PATCH":
			response = reqSpec.patch(value);
			break;
		case "DELETE":
			response = reqSpec.delete(value);
			break;
		default:
			break;
		}
		return response;
	}


	public static int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public static String asString(Response response) {
		return response.asString();

	}
	public static String asPrettyString(Response response) {
		return response.asPrettyString();

	}
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	
}
