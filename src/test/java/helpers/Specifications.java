package helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.requestSpecification;

public class Specifications {
    protected static final String BASE_URL = PropertyProvider.getProperty("base.url");

    public static RequestSpecification initRequestSpecification() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .setAccept(ContentType.JSON);
        return requestSpecification = requestSpecBuilder.build();
    }
}
