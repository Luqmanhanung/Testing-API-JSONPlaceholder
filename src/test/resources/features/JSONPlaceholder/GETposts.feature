Feature: Get posts

  Scenario: Get posts with valid data
    Given GET posts article with valid path
    When Send request get posts
    Then Should response 200 OK

  Scenario: Get posts invalid paramater
    Given Get posts article with invalid parameter
    When Send request get posts article
    Then Should response 400 bad request

  Scenario: Get posts invalid paramater
    Given Get posts article with invalid parameter
    When Send request get posts invalid parameter
    Then Should response 400 bad request

    Scenario Outline: Get posts article invalid path
      Given GET posts article with invalid id "<id>"
      When Send request posts invalid path
      Then Should response 400 bad request
      Examples:
      | id      |
      | @#      |
      | wuuff   |

  Scenario Outline: Get posts article exceed the limit
    Given GET posts article with id exceed the limit <id>
    When Send request posts with id exceed the limit
    Then Should response 400 bad request
    Examples:
      | id    |
      | 400   |
      | 450   |


