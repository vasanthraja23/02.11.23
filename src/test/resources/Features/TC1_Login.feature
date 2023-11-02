@login
Feature: Login in Module API automation
Scenario: Get user logtoken from login endpoint
Given User add header
When User add basic authentication for login
And User send "POST" request for login endpoint
Then User should verify the status code is 200
And User should verify the login response body firstName present as "Vasanthraja" and get the logtoken saved

