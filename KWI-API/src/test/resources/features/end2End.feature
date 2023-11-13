Feature: Validate that the user is able to retrieves, update and delete of users, posts and  comments

  @CreateUsers
  Scenario Outline: Validate to create information of users <test case id> <test cases>

    Given The user navigates to users end point of JsonPlaceHolder API
    When The user makes a POST call to rest service with request body <requestBodyPath> and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                | statusCode | contentType                     | requestBodyPath                                       | responseBodyPath                               |
      | TC-CU-01     | when user making get call to retrieve all the users info | 201        | application/json; charset=utf-8 | src/test/resources/schemas/create/request/user11.json | src/test/resources/schemas/retrieve/users.json |


  @EndToEnd
  Scenario Outline: Validate to create information of posts <test case id> <test cases>

    Given The user navigates to posts end point of JsonPlaceHolder API
    When The user makes a POST call to rest service with request body <PostRequestBodyPath> and  get json response
    Then The user validates the response code as <PostStatusCode>
    And The user validates the response body <PostResponseBodyPath>
    Then The user navigates to users end point of JsonPlaceHolder API
    And The user provides a query param id<id>
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <GetStatusCode>
    And The user validates the response body <GetResponseBodyPath>
    Then The user navigates to PUT end point of JsonPlaceHolder API
    When The user makes a PUT call to rest service with request body <PutRequestBodyPath>, id <id> and  get json response
    Then The user validates the response code as <PutStatusCode>
    And The user validates the response body <PutResponseBodyPath>
    Then The user navigates to DELETE end point of JsonPlaceHolder API
    When The user makes a DELETE call to rest service with id <id> and  get json response
    Then The user validates the response code as <DeleteStatusCode>

    Examples:
      | test case id | test case        | PostRequestBodyPath                                   | PostStatusCode | PostResponseBodyPath                                   | id  | GetStatusCode | GetResponseBodyPath                                    | PutRequestBodyPath                                    | PutStatusCode | PutResponseBodyPath                                    | DeleteStatusCode |
      | TC-E2E-01    | when user do e2e | src/test/resources/schemas/create/request/post11.json | 201            | src/test/resources/schemas/create/response/post11.json | 101 | 200           | src/test/resources/schemas/create/response/post11.json | src/test/resources/schemas/update/request/put101.json | 200           | src/test/resources/schemas/update/response/user11.json | 204              |
