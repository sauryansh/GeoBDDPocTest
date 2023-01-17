Feature: POST Profile
  Test POST Operation using REST-assured
  @smoke
  Scenario: Verify POST Operation for Profile
    Given I perform POST operation with path params from "/posts/{profileNo}/profile" with body
      | name  | profile |
      | James | 4       |
    Then I should see the body has name as "James"

  Scenario: Verify POST Operation
    Given I perform POST operation from "/posts"
