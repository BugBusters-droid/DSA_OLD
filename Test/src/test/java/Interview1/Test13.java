package Interview1;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test13 {

    @Test
    public void test(){

        String s = "aaanbbcc";
        Map<Character, Integer> map = new HashMap();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else{
                map.put(s.charAt(i), 1);
            }
        }

        System.out.println(map);

//        int[] frequency = new int[26];
//
//        for(int i=0;i<s.length();i++){
//            frequency[s.charAt(i)]++;
//        }
//
//        for(int i=0; i<s.length(); i++){
//
//        }
    }

    public int maxTime(int a){
        int maximumTime = 0;
        int maxHrs = 2359;

        

        return maximumTime;
    }


    @Test
    public void test1(){
       int a = 2616;
        System.out.println(maxTime(a));
    }

}
