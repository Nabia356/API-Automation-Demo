Feature: Check Integrated Author and book Services

  Scenario Outline: Check the Request for Author and Book Record by Id
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with response specification


    Examples:
      | End Point          |
      | /api/v1/Authors/authors/books/1 |

  Scenario Outline: Check the Request for Author and Book Record by invalid Id
    Given Valid Request is prepared
    When Get request is send to server for end point "<End Point>"
    Then response is matches with invalid response specification

    Examples:
      | End Point          |
      | /api/v1/Authors/authors/books/11111111111111111111|