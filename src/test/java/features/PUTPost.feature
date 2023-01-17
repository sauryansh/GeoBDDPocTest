Feature: PUT Post Profile
  Verify PUT POST Operations
  @smoke
  Scenario: Verify PUT operation after POST
    Given I ensure to Perform POST operation for "/posts" with body as
      | id | title              | author               |
      | 7  | API Testing course | Execution Automation |
    And I perform PUT operation for "/posts/{postid}" with body as
      | id | title       | author               |
      | 7  | API Testing | Execution Automation |
    And I perform GET operation for "/posts/{postid}"
      | postid |
      | 7      |
    Then I should see the body with title as "API Testing"
