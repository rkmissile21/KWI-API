Feature: Validate that the user is able to retrieves information of users, posts and  comments

  @RetrieveUsers
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to users end point of JsonPlaceHolder API
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                | statusCode | contentType                     | responseBodyPath                               |
      | TC-RU-01     | when user making get call to retrieve all the users info | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/users.json |

  @RetrieveUsersByID
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to users end point of JsonPlaceHolder API
    And The user provides a query param id<id>
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                | id | statusCode | contentType                     | responseBodyPath                               |
      | TC-RUI-01    | when user making get call to retrieve all the users info | 1  | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/users.json |

  @RetrievePosts
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to posts end point of JsonPlaceHolder API
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                | statusCode | contentType                     | responseBodyPath                               |
      | TC-RP-01     | when user making get call to retrieve all the posts info | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/posts.json |

  @RetrievePostsByID
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to posts end point of JsonPlaceHolder API
    And The user provides a query param id<id>
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                | id | statusCode | contentType                     | responseBodyPath                               |
      | TC-RPI-01    | when user making get call to retrieve all the posts info | 1  | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/posts.json |


  @RetrieveComments
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to comments end point of JsonPlaceHolder API
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                   | statusCode | contentType                     | responseBodyPath                                  |
      | TC-RC-01     | when user making get call to retrieve all the comments info | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/comments.json |

  @RetrieveCommentsByID
  Scenario Outline: Validate to retrieve information of users <test case id> <test cases>

    Given The user navigates to comments end point of JsonPlaceHolder API
    And The user provides a query param id<id>
    When The user makes a get call to rest service and  get json response
    Then The user validates the response code as <statusCode>
    Then The user validates the content type as <contentType>
    And The user validates the response body <responseBodyPath>

    Examples:
      | test case id | test case                                                   | id | statusCode | contentType                     | responseBodyPath                                  |
      | TC-RCI-01    | when user making get call to retrieve all the comments info |    | 200        | application/json; charset=utf-8 | src/test/resources/schemas/retrieve/comments.json |


