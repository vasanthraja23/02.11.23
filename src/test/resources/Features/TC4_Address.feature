Feature: Address Module API Automation

  @address
  Scenario Outline: Verify add User address to the application through api
    Given User add header and Bearer authorization for accessing address endpoint
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name  | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | vasanthraja | sg        | 9487768811 | hhh       |    35 | 3659 |     101 |  600081 | chennai | Home         |

  Scenario Outline: Verify update User address to the application through api
    Given User add request body for add update address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateAddress endpoint
    Then User Should verify the status code is 200
    And User should verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name  | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |          1 | vasanthraja | sg        | 9487768811 | hhh       |    35 |   11 |     101 |  600081 | chennai | Home         |

  Scenario Outline: Verify get User address to the application through api
    Given User add header and Bearer authorization for accessing address endpoint
    And User send "GET" request for getUserAddress endpoint
    Then User Should verify the status code is 200
    And User should verify the getUserAddress response message matches "Address verified successfully"

  Scenario Outline: Verify delete user address to the application through api
    Given User add header and Bearer authorization for accessing address endpoint
    And User send "Delete" request for delete endpoint
    Then User Should verify the status code is 200
    And User should verify the delete response message matches "Address deleted successfully"
