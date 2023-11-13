package com.kwi.teststepdef;

import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.kwi.base.BaseStep;
import com.kwi.base.CommonUtil;
import com.kwi.config.Property;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.jboss.logging.Logger;
import org.junit.Assert;

import java.io.File;
import java.nio.file.Paths;

import static com.kwi.config.Constants.API_END_POINT;
import static com.kwi.config.PropertyUtils.getProperty;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class CommonStepDefs {

    private static final Logger LOGGER = Logger.getLogger(CommonStepDefs.class);

    @Before
    public void init() {
        BaseStep.clear();
    }

    @When("^The user makes a get call to rest service and  get json response$")
    public void the_user_makes_a_get_call_to_rest_service_and_get_json_response() {
        Response response = CommonUtil.config().headers(CommonUtil.updateHeader(BaseStep.getHeaderAttribute())).queryParams(CommonUtil.updateQuery(BaseStep.getQueryAttribute())).get((String) BaseStep.getAttribute(API_END_POINT));
        BaseStep.setResponse(response);

//        LOGGER.info("Response Body: " + response.getBody().prettyPrint());
//        LOGGER.info("Response Body: " + response.getBody().asPrettyString());
        LOGGER.info("Response Body: " + response.getBody().asString());
    }

    @When("^The user makes a POST call to rest service with request body (.*) and  get json response$")
    public void theUserMakesAPOSTCallToRestServiceWithRequestBodyBodyPathAndGetJsonResponse(String bodyPath) {

        File requestBody = new File(bodyPath);
        Response response = CommonUtil.config().headers(CommonUtil.updateHeader(BaseStep.getHeaderAttribute())).body(requestBody).post((String) BaseStep.getAttribute(API_END_POINT));
        BaseStep.setResponse(response);

//      LOGGER.info("Response Body: " + response.getBody().prettyPrint());
//      LOGGER.info("Response Body: " + response.getBody().asPrettyString());
        LOGGER.info("Response Body: " + response.getBody().asString());
    }


    @Then("^The user validates the response code as (.*)$")
    public void the_user_validates_the_response_code_as(int statusCode) {
        try {
            Response response = BaseStep.getResponse();
            //System.out.println("response in status code step ====" + response.statusCode());
            Assert.assertEquals(statusCode, response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^The user validates the response body (.*)$")
    public void the_user_validates_the_response_body(String responseBodyPath) {

        try {

            Response response = BaseStep.getResponse();
            String responseBody = response.getBody().asString();

            // Load the JSON schema from file
            File schemaFile = Paths.get(responseBodyPath).toFile();
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.newBuilder().freeze();
            JsonSchema schema = schemaFactory.getJsonSchema(schemaFile.toURI().toString());
            // Validate the response body against the JSON schema
            schema.validate(JsonLoader.fromString(responseBody));
            // validate response body
            response.then().assertThat()
                    .body(matchesJsonSchemaInClasspath(responseBodyPath));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Then("^The user validates the content type as (.*)$")
    public void theUserValidatesTheContentTypeAsContentType(String contentType) {
        try {
            Response response = BaseStep.getResponse();
            //System.out.println("response in status code step ====" + response.statusCode());
            Assert.assertEquals(contentType, response.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^The user makes a PUT call to rest service with request body (.*), id (.*) and  get json response$")
    public void theUserMakesAPUTCallToRestServiceWithRequestBodyRequestBodyPathIdIdAndGetJsonResponse(String bodyPath, String id) {
        File requestBody = new File(bodyPath);
        Response response = CommonUtil.config().headers(CommonUtil.updateHeader(BaseStep.getHeaderAttribute())).body(requestBody).put((String) BaseStep.getAttribute(API_END_POINT), id);
        BaseStep.setResponse(response);

//      LOGGER.info("Response Body: " + response.getBody().prettyPrint());
//      LOGGER.info("Response Body: " + response.getBody().asPrettyString());
        LOGGER.info("Response Body: " + response.getBody().asString());
    }


    @Given("The user navigates to PUT end point of JsonPlaceHolder API")
    public void theUserNavigatesToPUTEndPointOfJsonPlaceHolderAPI() {
        BaseStep.setAttribute(API_END_POINT, getProperty(Property.PATH_PUT_POSTS_ID));

    }

    @Given("The user navigates to DELETE end point of JsonPlaceHolder API")
    public void theUserNavigatesToDELETEEndPointOfJsonPlaceHolderAPI() {
        BaseStep.setAttribute(API_END_POINT, getProperty(Property.PATH_DELETE_POSTS_ID));

    }

    @When("^The user makes a DELETE call to rest service with id (.*) and  get json response$")
    public void theUserMakesADELETECallToRestServiceWithIdIdAndGetJsonResponse(String id) {
        Response response = CommonUtil.config().headers(CommonUtil.updateHeader(BaseStep.getHeaderAttribute())).queryParams(CommonUtil.updateQuery(BaseStep.getQueryAttribute())).get((String) BaseStep.getAttribute(API_END_POINT), id);
        BaseStep.setResponse(response);

//        LOGGER.info("Response Body: " + response.getBody().prettyPrint());
//        LOGGER.info("Response Body: " + response.getBody().asPrettyString());
        LOGGER.info("Response Body: " + response.getBody().asString());
    }
}
