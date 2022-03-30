package Interview1;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test5 {

    @Test
    public void test(){
        int[] arr = {1,3,4,5,6,7,8,9,10};
        int sum = arr[0];

        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(num != sum){
                System.out.println(sum);
                sum++;
            }
            sum++;
        }
    }

    @Test
    public void test1(){
        String s = "abcdaeba";
        char[] ch = s.toCharArray();
        int count = 0;
        Map map = new HashMap<>();


        for(int i=0;i<s.length();i++){
            char ele = ch[i];
            for(int j=i;j<s.length();j++){
                if(ele==ch[j]){
                  count++;
                  if(count>1) {
                      map.put(ele,count);
                      if(Integer.valueOf(map.get(ele).toString())>count){
                          System.out.println(ele+","+count);
                      }
                  }
                }
            }
            count=0;
        }
    }


}
