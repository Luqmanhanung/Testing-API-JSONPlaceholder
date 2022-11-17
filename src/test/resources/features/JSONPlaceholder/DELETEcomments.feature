Feature: Delete comments article

  Scenario Outline: Delete comments article with valid id
    Given Delete comments with valid id <id>
    When Send request delete comments id
    Then API should return response 200 OK
    Examples:
    |id|
    |1 |
    |2 |

  Scenario Outline: Delete comments article with invalid id
    Given Delete comments with invalid id "<id>"
    When Send request delete comments string
    Then  API should return response 400 BAD REQUEST
    Examples:
    |id|
    |asa|
    |@#$|

  Scenario Outline: Delete comments article with id exceed the limit
    Given Delete comments with id exceed the limit <id>
    When Send request delete comments id
    Then API should return response 404 Not Found
    Examples:
    |id|
    |1001|
    |5023|