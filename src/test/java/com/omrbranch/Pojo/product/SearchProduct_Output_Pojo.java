package com.omrbranch.Pojo.product;

import java.util.ArrayList;

import com.omrbranch.Pojo.address.StateList;


public class SearchProduct_Output_Pojo {
	public int status;
    public String message;
    public ArrayList<GroceryList> data;
    public String currency;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<GroceryList> getData() {
		return data;
	}
	public void setData(ArrayList<GroceryList> data) {
		this.data = data;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
