Feature: Check All Activities Services

  Scenario Outline: Check the Request for All Activities Records
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with response specification


    Examples:
      | End Point         |
      | /api/v1/Activities |

  Scenario Outline: Check the Request for Activities Record by Id
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Value at json path "title" is equals to "Activity 1"


    Examples:
      | End Point          |
      | /api/v1/Activities/1 |

  Scenario Outline: Create New Activities Record in The Application
    Given Valid Request is prepared
    And Request payload is created for activities
    When Post request is send to server for end point "<End Point>"
    Then response is matches with response specification
    And Extract Activities id from json path

    Examples:
      | End Point      |
      | /api/v1/Activities |



  Scenario Outline: Update the Request for Activities Record by Id
    Given Valid Request is prepared
    And Update newly created activities record
    When Put request is send to server for end point "<End Point>"
    Then response is matches with response specification

    Examples:
      | End Point       |
      | /api/v1/Activities/ |


  Scenario Outline: Check the Request for Delete Employee Record
    Given Valid Request is prepared
    When Delete request is send to server for end point "<End Point>"
    Then response is matches with delete response specification


    Examples:
      | End Point       |
      | /api/v1/Activities/ |

#    Negative cases
  Scenario Outline: Create New Activities Record with invalid data in The Application
    Given Valid Request is prepared
    And Request payload is created for invalid data for activities
    When Post request is send to server for end point "<End Point>"
    Then response is matches with invalid response specification

    Examples:
      | End Point      |
      | /api/v1/Activities |

  Scenario Outline: Update the Request for invalid Activities Record by Id
    Given Valid Request is prepared
    And Update newly created with invalid activities record
    When Put request is send to server for end point "<End Point>"
    Then response is matches with invalid response specification

    Examples:
      | End Point       |
      | /api/v1/Activities/ |

  Scenario Outline: Check the Request for Activities Record by invalid Id
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with not found response specification
    And Value at json path "title" is equals to "Not Found"


    Examples:
      | End Point          |
      | /api/v1/Activities/1000 |