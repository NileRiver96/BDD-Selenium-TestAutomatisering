Feature: User Registration

  Scenario: User Signup
    Given  I navigate to "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When  I enter valid registration details
   And I accept the terms and conditions
    Then the user account should be created successfully


  Scenario: Scenario: User signs up without entering last name
   Given I navigate to "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When I enter valid registration details without last name
   And I accept the terms and conditions
   Then The registration form should show an error message asking the user to enter last name
    And The user account should not be created


    Scenario: User signs up with mismatched password
    Given I navigate to "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When I enter valid registration with mismatched password
    And I accept the terms and conditions
    Then The registration form should show an error message that the Password did not match
    And The user account should not be created


    Scenario: User signs up without accepting terms and conditions
    Given I navigate to "https://membership.basketballengland.co.uk/NewSupporterAccount"
      When I enter valid registration details
    And I dont accept the terms and conditions
    Then The registration form should show an error message that i need to accept the terms and conditions
    And The user account should not be created


