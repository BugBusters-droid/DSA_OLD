package com;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Helper {

    Constants constants = new Constants();

    public String getUsersDetail(){
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", constants.TYPE_JSON);
        String response = spec.get(constants.GET_USER_URL).asString();
        return response;
    }

}
