package com.kwi.teststepdef;

import com.kwi.base.BaseStep;
import com.kwi.config.Property;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.kwi.config.Constants.API_END_POINT;
import static com.kwi.config.Constants.ID;
import static com.kwi.config.PropertyUtils.getProperty;

public class GetRetrieveData {

    @Given("The user navigates to users end point of JsonPlaceHolder API")
    public void theUserNavigatesToUsersEndPointOfJsonPlaceHolderAPI() {
        BaseStep.setAttribute(API_END_POINT, getProperty(Property.PATH_GET_USERS));
    }

    @Given("The user navigates to posts end point of JsonPlaceHolder API")
    public void theUserNavigatesToPostsEndPointOfJsonPlaceHolderAPI() {
        BaseStep.setAttribute(API_END_POINT, getProperty(Property.PATH_GET_POSTS));
    }

    @Given("The user navigates to comments end point of JsonPlaceHolder API")
    public void theUserNavigatesToCommentsEndPointOfJsonPlaceHolderAPI() {
        BaseStep.setAttribute(API_END_POINT, getProperty(Property.PATH_GET_COMMENTS));
    }

    @And("^The user provides a query param id(.*)$")
    public void theUserProvidesAQueryParamIdId(String id) {
        BaseStep.setQueryAttribute(ID, id.trim());
    }
}
