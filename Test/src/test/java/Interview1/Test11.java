package Interview1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test11 {

    @Test
    public void test(){
        int[] arr = {24, 66, 78 ,89, 54, 51, 91, 90, 67};
        int temp = 0;
        int secondLargest=0;

        for(int i=0;i<arr.length;i++){
            temp=Math.max(temp,arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]<temp) {
                secondLargest = Math.max(secondLargest, arr[i]);
            }
        }
        System.out.println(secondLargest);
    }

    @Test(description = "first non repeating character")
    public void test1(){
        String s = "abcdeabd";
        char[] ch = s.toCharArray();

        int totalChars = 256;
        char[] count = new char[totalChars];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }

        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)]==1){
                System.out.println(s.charAt(i));
                break;
            }
        }
    }


}
