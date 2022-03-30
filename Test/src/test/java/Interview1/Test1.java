package Interview1;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {


    @Test
    public void test1(){

        RequestSpecification spec = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.append("name", "morpheus");
        requestParams.append("job", "leader");

        spec.header("Content-Type", "application/json");
        spec.body(requestParams.toString());
        String resp = spec.post("https://reqres.in/api/users").asString();
        System.out.println(resp);

        JSONObject jsonObject = new JSONObject(resp);
        Assert.assertEquals(jsonObject.get("name").toString(), requestParams.get("name").toString());
        Assert.assertEquals(jsonObject.get("job").toString(), requestParams.get("job").toString());
    }

    @Test()
    public void test2(){

        RequestSpecification spec = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.append("name", "morpheus");
        requestParams.append("job", "leader");

        spec.header("Content-Type", "application/json");
        spec.body(requestParams.toString());
        String resp = spec.post("https://reqres.in/api/users").asString();
        System.out.println(resp);

        JSONObject jsonObject = new JSONObject(resp);
        Assert.assertTrue(jsonObject.toString().contains("id"));
        Assert.assertTrue(jsonObject.get("createdAt").toString().contains("2022-02-09"));
    }

    @Test
    public void test(){

            int arr[] = { 4, 3, 2, 1,5,6,7,8 };

            for (int i = 0; i <= arr.length-1; i++) {


                for (int j = i + 1; j <= arr.length-1; j++) {


                    int temp = 0;
                    if (arr[j] < arr[i]) {


                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }


                System.out.print(arr[i] + " ");
            }

        }

}
