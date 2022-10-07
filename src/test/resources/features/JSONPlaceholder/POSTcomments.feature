Feature: POST create comments
  Scenario Outline: POST create comment with valid path and valid all data
    Given Post create comment with valid path and valid all data
    When Send request post create comment
    Then Api should return response 201 Created
    And Response body should contain user Id <user id>, name "<name>", email "<email>", body "<body>" and id <id>
  Examples:
      |user id | name | email | body | id |
      | 2      | budi | budi@email.com | pagi | 501 |

  Scenario: POST create comments with valid path and empty Request body only one field
    Given post create comments with valid path and empty Request body only one field
    When Send request post create comment
    Then API should return response 400 BAD REQUEST

  Scenario: POST create comments with valid path and empty Request body only two field
    Given post create comments with valid path and empty Request body only two field
    When Send request post create comment
    Then API should return response 400 BAD REQUEST

  Scenario: POST create comments with valid path and empty Request body only three field
    Given post create comments with valid path and empty Request body only three field
    When Send request post create comment
    Then API should return response 400 BAD REQUEST

  Scenario: POST create comments with valid path and Invalid all data
    Given Post create comments with valid path and Invalid all data
    When Send request post create post
    Then API should return response 400 BAD REQUEST