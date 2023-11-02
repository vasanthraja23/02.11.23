@search
Feature: Product Module API Automation

  Scenario: Verify search product to the application through api
    Given User add header for to searchProduct
    When User add request body text for get productList
    And User send "POST" request for SearchProduct endpoint
    Then User should verify the status code is 200
    And User should verify the productList response message matches "Ok" and saved categoryId and id and type
