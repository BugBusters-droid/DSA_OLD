package Interview1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test15 {

    @Test
    public void test(){
        String str= "teetotlar";
        char[] ch = str.toCharArray();
        int count=0;
        List lst = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            char firstChar = ch[i];
            count=0;
            for(int j=0;j<str.length() ;j++){
                if(firstChar==ch[j]){
                    count++;
                }
            }
            if(count==1){
                lst.add(ch[i]);
            }
//            for(int j=i+1;j<str.length()-1;j++){
//                if(firstChar==ch[j]){
//                    count++;
//                    break;
//                }
//            }
//            if(count==1) {
//                System.out.println(ch[i]);
//            }
        }

        System.out.println("first non repeating char ::: "+lst.get(0));
    }

    @Test
    public void test1(){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.writeValueAsString(object);
        String sampleJson = "{\"pageInfo\": {\"pageName\": \"Codezup Homepage\",\"logo\": \"https://codezup.com/logo.jpg\"},\"posts\": [{\"post_id\": \"987456123\",\"actor_id\": \"101\",\"author_name\": \"Robert\",\"post_title\": \"How to parse JSON in Java by codezup.com\",\"comments\": [],\"time_of_post\": \"5689563245\"}]}";
        JSONObject jsonObject = new JSONObject(sampleJson);
        System.out.println(jsonObject.getJSONObject("pageInfo").get("pageName"));
        JSONArray arr = jsonObject.getJSONArray("posts");
        System.out.println(arr.getJSONObject(0).get("post_id"));
    }

    @Test
    public void test2(){
        RequestSpecification request = RestAssured.given();
        Response resp = request.get("https://reqres.in/api/users?page=2");
        System.out.println(resp.asString());

        request.header("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "venkatesh");
        jsonObject.put("job", "engineer");
        request.body(jsonObject.toString());
        Response respPost = request.post("https://reqres.in/api/users");
        System.out.println(respPost.asString());

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "venkatesh");
        jsonObject1.put("job", "engineer1");
        request.body(jsonObject1.toString());
        Response respPost1 = request.put("https://reqres.in/api/users");
        System.out.println(respPost1.asString());

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("job", "engineer2");
        request.body(jsonObject2.toString());
        Response respPost2 = request.put("https://reqres.in/api/users/2");
        System.out.println(respPost2.asString());

    }
}
