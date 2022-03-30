package Interview1;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test3 {

    @Test
    public void test(){
        int[] arr = {1,9,2,3,4,5,6,7,0,3,1,-10,10,20};
        int sum =10;
        int temp[]= new int[arr.length];
        int k=0;

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (first + arr[j] == sum) {
                    //System.out.println("{" + first + "," + arr[j] + "}");
                    if(temp.toString().contains(String.valueOf(first)) || !temp.toString().contains(String.valueOf(arr[j]))) {
                        temp[k] = first;
                        k++;
                        temp[k] = arr[j];
                    }
                    k++;
                    break;
                }
            }
        }
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]);
        }
    }

    @Test
    public void test1(){
        String s = "{\"id\":01,\"name\":\"venkatesh\",\"details\":{\"test01\":01,\"test02\":02}}";
        JSONObject jsonObject = new JSONObject(s);
        System.out.println(jsonObject.get("id"));
        System.out.println(new JSONObject(jsonObject.get("details").toString()).get("test02"));
    }

}
