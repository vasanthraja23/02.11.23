package com.omrbranch.payload.address;

import com.omrbranch.Pojo.address.AddAddress_Input_Pojo;
import com.omrbranch.Pojo.address.CityList_Input_Pojo;
import com.omrbranch.Pojo.address.DeleteAddress_Input_Pojo;
import com.omrbranch.Pojo.address.DeleteAddress_Output_Pojo;
import com.omrbranch.Pojo.address.UpdateAddress_Input_Pojo;


public class AddressPayLoad {
	
public  CityList_Input_Pojo getCityListPayLoad(String stateId) {
	CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateId);
	return cityList_Input_Pojo;
}

public AddAddress_Input_Pojo addAddress(String first_name,String last_name,String mobile,String apartment,int state,int city,int country,String zipcode,String address,String address_type) 
{
AddAddress_Input_Pojo addUserAddress_Input_Pojo= new AddAddress_Input_Pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);

return addUserAddress_Input_Pojo;
}

public UpdateAddress_Input_Pojo updateUser(String address_id,String first_name,String last_name,String mobile,String apartment,int state,int city,int country,String zipcode,String address,String address_type)
{
UpdateAddress_Input_Pojo updateUserAddress_Input_Pojo=new UpdateAddress_Input_Pojo(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
return updateUserAddress_Input_Pojo;
}
public DeleteAddress_Input_Pojo deleteAddress(String AddressId)
{
DeleteAddress_Input_Pojo deleteAddress_Input_Pojo=new DeleteAddress_Input_Pojo(AddressId);
return deleteAddress_Input_Pojo;
}

}