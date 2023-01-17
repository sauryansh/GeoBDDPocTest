Feature:
  Verify different GET operations using REST-Assured

  Scenario: Verify one author of the post
    Given I perform GET operation from "/posts"
    #And I perform GET operation for the post number "1"
    Then I should see the author name "KK"

  Scenario: Verify collections of authors in the post
    Given I perform GET operation from "/posts"
    Then I should see the author names

  Scenario: Verify Path Params Parameter in GET API Call
    Given I perform GET operation from "/posts/1"
    Then I should verify GET Params

  Scenario: Verify Query Params Parameter in GET API Call
    Given I perform GET operation from "/posts"
    And query params "id" and "1"
    Then I should verify Query Params






