Feature: Get posts

  Scenario: Get posts with valid data
    Given GET posts article with valid path
    When Send request get posts
    Then API should return response 200 OK

  Scenario: Get posts invalid paramater
    Given Get posts article with invalid parameter
    When Send request get posts article
    Then API should return response 400 BAD REQUEST

  Scenario: Get posts invalid paramater
    Given Get posts article with invalid parameter
    When Send request get posts invalid parameter
    Then API should return response 400 BAD REQUEST

    Scenario Outline: Get posts article invalid path
      Given GET posts article with invalid id "<id>"
      When Send request posts invalid path
      Then API should return response 404 Not Found
      Examples:
      | id      |
      | @#      |
      | wuuff   |

  Scenario Outline: Get posts article exceed the limit
    Given GET posts article with id exceed the limit <id>
    When Send request posts with id exceed the limit
    Then API should return response 404 Not Found
    Examples:
      | id    |
      | 400   |
      | 450   |


