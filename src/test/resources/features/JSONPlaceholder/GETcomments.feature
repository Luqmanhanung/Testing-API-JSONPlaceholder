Feature: GET comments feature

  Scenario Outline: Get comments all article
    Given Get all comments article
    When Send request get all comments
    Then API should return response 200 OK
    And Response body page should contain post id <postId>, id <id>, name "<name>", email "<email>" and body "<body>"
    And Get all comments json schema validator
    Examples:
    | postId | id | name | email | body |
    | 1      | 1  | id labore ex et quam laborum | Eliseo@gardner.biz | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |


  Scenario Outline: Get comments with valid id
    Given Get comments valid id <id>
    When Send request get comments valid id
    Then API should return response 200 OK
    And Response body page should contains post id <postId>, id <id>, name "<name>", email "<email>" and body "<body>"
    And Get comments with valid id json schema validator
    Examples:
    | postId | id | name | email | body |
    | 1      | 1  | id labore ex et quam laborum | Eliseo@gardner.biz | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |


  Scenario Outline: Get comments with invalid id
    Given Get comments invalid id "<id>"
    When Send request get comments invalid id
    Then API should return response 400 BAD REQUEST
    Examples:
    | id  |
    | asa |
    | @#$ |


  Scenario Outline: Get comments with id exceed the limit
    Given Get comments valid id <id>
    When Send request get comments valid id
    Then API should return response 404 Not Found
    Examples:
    | id |
    | 501 |
    | 502 |


  Scenario Outline: get comments with valid field parameter using id
    Given Get comments valid id <id>
    When Send request get comments parameter
    Then API should return response 200 OK
    And Response body page should contain post id <postId>, id <id>, name "<name>", email "<email>" and body "<body>"
    And Get comments with parameter json schema validator
    Examples:
      | postId | id | name | email | body |
      | 1      | 1  | id labore ex et quam laborum | Eliseo@gardner.biz | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |





