package com.omrbranch.payloadmanager;

import com.omrbranch.payload.address.AddressPayLoad;

import com.omrbranch.payload.product.ProductPayload;

public class PayloadObjectManager {
	private AddressPayLoad addresspayload;
	private ProductPayload productpayload;
	
	public AddressPayLoad getAddresPayload() {
		return (addresspayload == null)? addresspayload = new AddressPayLoad():addresspayload;
		
	}
	public ProductPayload getProductPayload() {
		return (productpayload == null)? productpayload = new ProductPayload():productpayload;
		
	}
	

}
