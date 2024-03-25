Feature: User Registration

  Scenario Outline: User Signup

    Given I go to wished "<site>" on "<browser>"
    When I enter registration details "<first name>", "<last name>", "<email>", "<password>", and "<confirm password>"
    And I accept the terms "<accept terms>"
    Then A user account should be created succesfully and a "<message type>" message should be displayed

    Examples:
      | browser | site                                                           | first name | last name | email                         | password | confirm password | accept terms | message type    |  |
      | Chrome  | https://membership.basketballengland.co.uk/NewSupporterAccount | Saleh      | Alisheik  | Saleh.Idrisidriss@outlook.com | Amira1   | Amira1           | acceptOne    | success         |  |
      | Firefox | https://membership.basketballengland.co.uk/NewSupporterAccount | Saleh      |           | Saleh.A@outlook.com           | Amira1   | Amira1           | acceptTwo    | errorLastname   |  |
      | Chrome  | https://membership.basketballengland.co.uk/NewSupporterAccount | Saleh      | Alisheik  | Saleh.A@outlook.com           | Amira1   | Amira            | acceptThree  | errorMismatched |  |
      | Firefox | https://membership.basketballengland.co.uk/NewSupporterAccount | Saleh      | Alisheik  | Saleh.A@outlook.com           | Amira1   | Amira1           | notAccept    | errorTerms      |  |