Feature: POST create posts
  Scenario Outline: POST create post with valid path and valid all data
    Given Post create post with valid path and valid all data
    When Send request post create post
    Then Api should return response 201 Created
    And Response body should contain user Id <user id>, title "<title>", body "<body>", and id <id>
    And Post create user assert json validation
  Examples:
    |user id | title | body | id |
    | 2      | halo  | pagi | 101 |

  Scenario: POST create posts with valid path and empty Request body only one field
    Given post create posts with valid path and empty Request body only one field
    When Send request post create post
    Then API should return response 400 BAD REQUEST


  Scenario: POST create posts with valid path and empty Request body only two field
    Given post create posts with valid path and empty Request body only two field
    When Send request post create post
    Then API should return response 400 BAD REQUEST

  Scenario: POST create post with valid path and Invalid all data
    Given Post create post with valid path and Invalid all data
    When Send request post create post
    Then API should return response 400 BAD REQUEST

  Scenario: POST create post with invalid path
    Given Post create post with invalid path
    When Send request post invalid create post
    Then API should return response 400 BAD REQUEST




