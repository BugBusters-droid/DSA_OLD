package Interview1;

import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test22 {


    /**
     * {‘customer1’: ‘100’, ‘customer2’: ‘250.5’, ‘customer3’: ’150‘, ‘customer4’: ‘10’, ‘customer5’: ‘80.5’, ‘customer6’: ‘’, ‘customer7’: ‘&^%^’}
     */

    public JSONObject discount(String s){
        JSONObject jsonObject = new JSONObject(s);
        int k=1;
        JSONObject jsonObject1 = new JSONObject();

        for(int i=0;i<jsonObject.length();i++){
            String key = "customer"+k;
//            if(jsonObject.get(key).toString().equalsIgnoreCase("") || jsonObject.get(key).toString().equalsIgnoreCase("&^%^") ){
//                jsonObject1.put(key, 50);
//            }
            int value = 0;
            try {
                value = Integer.parseInt(jsonObject.get(key).toString());
            } catch(Exception e){
                jsonObject1.put(key, 50);
            }
            if(value>100){
                jsonObject1.put(key, value - (0.1*value));
                System.out.println(value - (10/100)*value);
            } else if(value<=100){
                jsonObject1.put(key, value);
                System.out.println(value);
            } else{
                jsonObject1.put(key, 50);
                System.out.println(50);
            }
            k++;
        }
        return jsonObject1;
    }

    @Test
    public void test(){

        String s = "{\"customer1\":\"100\",\"customer2\":\"250\",\"customer3\":\"150\",\"customer4\":\"10\",\"customer5\":\"80\",\"customer6\":\"\",\"customer7\":\"&^%^\"}";
        JSONObject jsonObject = discount(s);
        System.out.println(jsonObject.toString());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("customer1", "100");
//        jsonObject.put("customer2", "250.5");
//        jsonObject.put("customer3", "150");
//        jsonObject.put("customer4", "10");
//        jsonObject.put("customer5", "80.5");
//        jsonObject.put("customer6", "");
//        jsonObject.put("customer7", "100");
    }

    /**
     * {"customer6":0,"customer7":0,"customer4":10,"customer5":80,"customer2":225,"customer3":135,"customer1":100}
     * {‘customer1’: ‘100’, ‘customer2’: ‘250.5’, ‘customer3’: ’150‘, ‘customer4’: ‘10’, ‘customer5’: ‘80.5’, ‘customer6’: ‘’, ‘customer7’: ‘&^%^’}
     */


    // tail -f abc.log | grep "ERROR"

    @Test(enabled = false)
    public void test2(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

}
