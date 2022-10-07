Feature: Delete comments article

  Scenario Outline: Delete comments article with valid id
    Given Delete comments with valid id <id>
    When Send request delete comments id
    Then Should return 204 No Content
    Examples:
    |id|
    |1 |
    |2 |

  Scenario Outline: Delete comments article with invalid id
    Given Delete comments with invalid id "<id>"
    When Send request delete comments string
    Then Should return 400 Bad Request
    Examples:
    |id|
    |asa|
    |@#$|

  Scenario Outline: Delete comments article with id exceed the limit
    Given Delete comments with id exceed the limit <id>
    When Send request delete comments id
    Then Should return 404 Not Found
    Examples:
    |id|
    |501|
    |502|