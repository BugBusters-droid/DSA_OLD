package Interview1;

import com.Helper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Test4 {

    Helper helper = new Helper();
    @Test
    public void test(){
        SoftAssert softAssert = new SoftAssert();
        String userData = helper.getUsersDetail();
        System.out.println("response is ::: "+userData);
        JSONObject jsonObject = new JSONObject(userData);
        softAssert.assertEquals(jsonObject.get("page").toString(), "1");
        softAssert.assertEquals(jsonObject.get("per_page").toString(), "6");
        Assert.assertNotNull(jsonObject.get("data"));
        softAssert.assertAll();
    }




}
