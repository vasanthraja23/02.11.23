package com.omrbranch.Pojo.address;

import java.util.ArrayList;

public class GetAddress_Output_Pojo {
	public int status;
    public String message;
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
	public ArrayList<AddressList> getData() {
		return data;
	}
	public void setData(ArrayList<AddressList> data) {
		this.data = data;
	}
	public ArrayList<AddressList> data;

}
