Feature: PATCH posts article

  Scenario Outline: Patch posts article with valid id
    Given Patch posts with valid id <id>
    When Send request patch posts id
    Then API should return response 200 OK
    And Response body page should contain user id <userId>, id <id>, title "<title>" and body "<body>"
    And Patch posts article json schema validator
    Examples:
    | id | userId | title | body |
    | 1  | 1      | Testing update | Cobain testing artikel |



  Scenario Outline: Patch posts article with invalid id
    Given Patch posts with invalid id "<id>"
    When Send request patch posts invalid id
    Then API should return response 400 BAD REQUEST
    Examples:
    | id |
    | asa |
    | @#$ |

  Scenario Outline: Patch posts article with id exceed the limit
    Given Patch posts with id exceed the limit <id>
    When Send request patch posts id
    Then API should return response 404 Not Found
    Examples:
    | id |
    | 101 |
    | 102 |

  Scenario Outline: Patch posts article with all valid data
    Given Patch posts with valid id <id>
    When Send request patch posts id
    Then API should return response 200 OK
    And Response body page should contain user id <userId>, id <id>, title "<title>" and body "<body>"
    And Patch posts article json schema validator
    Examples:
      | id | userId | title | body |
      | 1  | 1      | Testing update | Cobain testing artikel |


  Scenario Outline: Patch posts article with only one field
    Given Patch posts with valid id half <id>
    When Send request patch posts id
    Then API should return response 200 OK
    And Response body page should contain user id <userId>, id <id>, title "<title>" and body "<body>"
    And Patch posts article json schema validator
    Examples:
    | id | userId | title | body |
    | 1  | 1 | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | Cobain testing artikel |
