package com.kwi.base;

import io.restassured.response.Response;

import java.util.Map;

public class BaseStep {

    //Context
    private static ContextAttributes context() {
        return ContextAttributes.getInstance();
    }

    public static Object getAttribute(String attributeName) {
        return context().getAttributes(attributeName);
    }


    public static void setAttribute(String key, Object value) {
        context().setAttributes(key, value);
    }

    //clear the previous data
    public static void clear() {
        context().clear();
        headerContext().clear();
        queryContext().clear();
    }

    //Response
    public static Response getResponse() {
        return (Response) context().getAttributes("response");
    }

    public static void setResponse(Object response) {
        context().setAttributes("response", response);
    }


    //Header
    private static HeaderAttributes headerContext() {
        return HeaderAttributes.getInstance();

    }

    public static void setHeaderAttribute(String key, String value) {
        headerContext().setHeaderAttributes(key, value);
    }

    public static Map<String, String> getHeaderAttribute() {
        return headerContext().getHeaderAttributes();
    }

    //Query

    private static QueryAttributes queryContext() {
        return QueryAttributes.getInstance();

    }

    public static void setQueryAttribute(String key, String value) {
        queryContext().setQueryAttributes(key, value);
    }

    public static Map<String, String> getQueryAttribute() {
        return queryContext().getQueryAttributes();
    }


}
