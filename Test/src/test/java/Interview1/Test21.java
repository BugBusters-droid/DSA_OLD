package Interview1;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test21 {


    /**
     * POST https://api-stage.rupifi.com/v1/merchants/auth/token
     * Request body
     * {
     *    "merchantId": "TESTCLIENT",
     *    "merchantSecret": "OGFlN2Q2MGItMmJiYy00OTU0LWE1MWItMTU1OGJmYTU4YThm"
     * }
     */

    @Test
    public void test(){
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("merchantId", "TESTCLIENT");
        jsonObject.put("merchantSecret", "OGFlN2Q2MGItMmJiYy00OTU0LWE1MWItMTU1OGJmYTU4YThm");

        requestSpecification.header("Content-Type", "application/json");

        requestSpecification.body(jsonObject.toString());
        Response response = requestSpecification.post("https://api-stage.rupifi.com/v1/merchants/auth/token");

        JSONObject jsonObject1 = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject1.get("accessToken").toString();
        System.out.println("access token is ::: "+accessToken);
//        System.out.println(response.getBody().asString());


        /**
         * POST https://api-stage.rupifi.com/v1/customers/eligibility
         * Header:
         * Authorization: Bearer <token_received_in_prev_response>
         *
         * Request body
         * {
         *    "merchantCustomerRefId": "JC00001",
         *    "phone": "7259218955",
         *    "updateGMV": false
         * }
         */

        String merchantRefId = "JC00001";

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("merchantCustomerRefId", "JC00001");
        jsonObject2.put("phone", "7259218955");
        jsonObject2.put("updateGMV", false);

        requestSpecification.body(jsonObject2.toString());
        requestSpecification.header("Authorization", "Bearer "+accessToken);
        Response response1  = requestSpecification.post("https://api-stage.rupifi.com/v1/customers/eligibility");
        System.out.println(response1.getBody().asString());

        String data = new JSONObject(response1.getBody().asString()).get("data").toString();
        System.out.println("data is "+data);
        String merchantCustomerRefId = new JSONObject(data).get("merchantCustomerRefId").toString();
        System.out.println("merchant ref id from response is ::: "+merchantCustomerRefId);
        Assert.assertEquals(merchantRefId, merchantCustomerRefId);
    }
}
