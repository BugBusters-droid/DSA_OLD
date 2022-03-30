package Interview1;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test17 {

    @Test
    public void test(){
        String s = "venkatesh";
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i])+1);
            } else{
                map.put(ch[i], 1);
            }
        }
        System.out.println(map);
    }

    @Test
    public void test2(){
        String s = "venkatesh";
        int[] count = new int[256];
        char[] ch =  s.toCharArray();

        for(int i=0;i<s.length();i++){
            count[ch[i]]++;
        }
        for(int i=0;i<count.length;i++){
            System.out.println(count[i]+"-"+ch[i]);
        }
    }

    public boolean isPalindrome(int n){
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(ch[left]!=ch[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test3(){
       int n = 2132;
        System.out.println(isPalindrome(n));
    }
}
