Feature: PUT posts feature

  Scenario Outline: PUT update posts with valid data
    Given PUT with valid request body and valid path id <id>
    When Send request update user
    Then API should return response 200 OK
    And Response body should contain name "ANTARTIKA" and "BULAN"
    And PUT update posts schema validator
    Examples:
    | id |
    | 1  |
    | 2  |

  Scenario: PUT update posts with invalid data
      Given PUT with invalid id 101 and userId
      When Send request update user invalid
      Then API should return response 400 BAD REQUEST


  Scenario Outline: PUT update posts with empty title
    Given PUT with empty title id <id>
    When Send request update user with empty title
    Then API should return response 400 BAD REQUEST
    Examples:
    | id |
    | 1  |
    | 2  |

  Scenario Outline: PUT update posts with empty body
    Given PUT with empty body id <id>
    When Send request update user with empty body
    Then API should return response 400 BAD REQUEST
    Examples:
      | id |
      | 1  |
      | 2  |

  Scenario Outline: PUT update posts without title
    Given PUT without title <id>
    When Send request update user
    Then API should return response 400 BAD REQUEST
    Examples:
      | id |
      | 1  |
      | 2  |

  Scenario Outline: PUT update posts without body
    Given PUT without body <id>
    When Send request update user
    Then API should return response 400 BAD REQUEST
    Examples:
      | id |
      | 1  |
      | 2  |

  Scenario Outline: PUT update posts without id
    Given PUT without id <id>
    When Send request update user without id
    Then API should return response 404 Not Found
    Examples:
    | id |
    | 1  |
    | 2  |

  Scenario Outline: PUT update posts without id and userId
    Given PUT without id and userId <id>
    When Send request update user without id and userId
    Then API should return response 404 Not Found
    Examples:
      | id |
      | 3  |
      | 4  |

