package com.kwi.base;

import com.kwi.config.Property;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.kwi.config.PropertyUtils.getProperty;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class CommonUtil {

    static {
        RestAssured.baseURI = getProperty(Property.BASE_URL);
    }

    public static RequestSpecification config() {


        return RestAssured.given().config(RestAssured.config().encoderConfig(encoderConfig().and().appendDefaultContentCharsetToContentTypeIfUndefined(false)).and().sslConfig(new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON);
    }

    public static Map<String, String> updateHeader(Map<String, String> header) {
        header.keySet().stream().filter(headerKey -> header.get(headerKey).equals("null")).forEach(headerKey -> header.remove(headerKey));
        return header;
    }

    public static Map<String, String> updateQuery(Map<String, String> query) {
        query.keySet().stream().filter(queryParameter -> query.get(queryParameter).equals("null")).forEach(queryParameter -> query.remove(queryParameter));
        return query;
    }

}
