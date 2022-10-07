Feature: Delete posts article

  Scenario Outline: Delete posts article with valid id
    Given Delete posts with valid id <id>
    When Send request delete posts id
    Then Should return 204 No Content
    Examples:
      |id|
      |1 |
      |2 |

  Scenario Outline: Delete posts article with invalid id
    Given Delete posts with invalid id "<id>"
    When Send request delete posts string
    Then Should return 400 Bad Request
    Examples:
      |id|
      |asa|
      |@#$|

  Scenario Outline: Delete posts article with id exceed the limit
    Given Delete posts with id exceed the limit <id>
    When Send request delete posts id
    Then Should return 404 Not Found
    Examples:
      |id|
      |101|
      |102|