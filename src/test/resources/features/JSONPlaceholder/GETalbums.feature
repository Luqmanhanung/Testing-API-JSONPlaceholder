Feature: GET albums
  Scenario: GET list albums
    Given Get list all albums
    When Send request get list albums
    Then API should return response 200 OK
    And Response body list album should contain user id 1, id 1, and title "quidem molestiae enim"
    And Get list albums assert json validation

  Scenario Outline: GET single albums with valid id
    Given Get single all albums with valid id <id>
    When Send request get single albums
    Then API should return response 200 OK
    And Response body single album should contain user id <userid>, id <id>, and title "<title>"
    And Get single albums assert json validation
    Examples:
      | id | userid | title |
      |1   | 1      | quidem molestiae enim|
      |11  | 2      |quam nostrum impedit mollitia quod et dolor|

  Scenario Outline: GET list albums with invalid id
    Given Get single all albums with invalid id "<id>"
    When Send request get single albums
    Then API should return response 404 Not Found
    Examples:
      | id |
      |!#  |
      |as  |

  Scenario Outline: GET single albums with id exceed the limit
    Given Get single all albums with id exceed the limit <id>
    When Send request get single albums
    Then API should return response 404 Not Found
    Examples:
      | id |
      |101 |
      |200 |

  Scenario Outline: GET list albums with valid parameter
    Given Get list albums with valid parameter "<title>"
    When Send request get list albums with parameter
    Then API should return response 200 OK
    And Response body list album should contain user id 1, id 5, and title "eaque aut omnis a"
    And Get list albums assert json validation
  Examples:
    |title|
    |eaque aut omnis a|

