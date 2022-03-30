package Interview1;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test12 {


    public void space(List lst){
        int mid = 0;
        int lastMid = 0;

        for(int i=0;i<lst.size();i++){
            String s = lst.get(i).toString();
            JSONObject jsonObject = new JSONObject(s);
            mid = Integer.parseInt(jsonObject.get("mid").toString());

            if(mid>=1){
                for(int j=0;j<mid;j++){
                    System.out.print(" ");
                }
                System.out.print(jsonObject.get("name").toString());
                System.out.println();
            } else{
                System.out.println(jsonObject.get("name").toString());
            }
        }
    }

    @Test
    public void test(){
        List lst = new ArrayList();
        lst.add("{\"id\":1,\"name\":\"Eric\",\"mid\":-1}");
        lst.add("{\"id\":2,\"name\":\"Jack\",\"mid\":1}");
        lst.add("{\"id\":3,\"name\":\"Viral\",\"mid\":2}");
        lst.add("{\"id\":4,\"name\":\"Michael\",\"mid\":2}");
        lst.add("{\"id\":5,\"name\":\"Nitesh\",\"mid\":1}");
        lst.add("{\"id\":6,\"name\":\"George\",\"mid\":4}");
        lst.add("{\"id\":7,\"name\":\"Ryan\",\"mid\":2}");

        space(lst);
    }


    /**
     * test=[
      {"id":1,"name":"Eric","mid":-1},
      {"id":2,"name":"Jack","mid":1},
      {"id":3,"name":"Viral","mid":2},
      {"id":4,"name":"Michael","mid":2},
      {"id":5,"name":"Nitesh","mid":1},
      {"id":6,"name":"George","mid":4},
      {"id":6,"name":"Ryan","mid":2},
     * ]
     *
     *
     * ID     |   Name         |  Manager ID |
     * ---------------------------------------
     * 1      |   Eric         |  NULL       |
     * 2      |   Jack         |  1          |
     * 3      |   Viral        |  2          |
     * 4      |   Michael      |  2          |
     * 5      |   Nitesh       |  1          |
     * 6      |   George       |  4          |
     * 7      |   Ryan         |  2          |
     *
     * Eric
     * |__ Jack
     *    |__ Viral
     *    |__ Michael
     *       |__ George
     *    |__ Ryan
     * |__ Nitesh
     */
}
