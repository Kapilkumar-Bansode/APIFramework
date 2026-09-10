Feature: Validating Place API's
  @AddPlace @Regression
  Scenario Outline: Verify if Place is being added using AddPlaceAPI

    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceApi" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceApi"

    Examples:
      | name    | language | address |
      | Kingdom | Hindi    | WTC     |
      | Arsenal | English  | White   |

  @DeletePlace @Regression
  Scenario: Verify if Delete Place functionality is working

    Given DeletePlace Payload
    When user calls "deletePlaceApi" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
