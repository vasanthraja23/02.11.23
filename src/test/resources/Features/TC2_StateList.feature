@state
Feature: State in Module API automation
Scenario: Verify User get statelist through api
Given User add header for statelist
When User send "GET" request for statelist endpoint
Then User should verify the status code is 200
And User should verify the statelist response message matches "Tamil Nadu" and saved stateid

