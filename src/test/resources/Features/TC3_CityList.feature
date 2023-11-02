@city
Feature: City in Module API automation
Scenario: Verify User get citylist through api
Given User add header for citylist
When User add request body stateid for get city list
And User send "POST" request for citylist endpoint
Then User should verify the status code is 200
And User should verify the citylist response message matches  "Chennai" and saved cityid

