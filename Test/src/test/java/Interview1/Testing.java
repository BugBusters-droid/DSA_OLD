package Interview1;

import org.apache.http.HttpHeaders;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;


public class Testing {

//    public int lengthOfLastString(String s){
//        int length =0;
//        boolean flag = false;
//        for(int i =s.length()-1;i>=0;i--){
//            if(Character.isLetter(s.charAt(i))){
//                length++;
//                flag=true;
//            } else{
//                if(flag==true) {
//                    return length;
//                }
//            }
//        }
//        return length;
//    }

    public int lengthOfLastString(String s){
        int length =0;
        boolean flag = false;
        for(int i =s.length()-1;i>=0;i--){
            if(Character.isLetter(s.charAt(i))){
                length++;
                flag=true;
            } else{
                if(flag==true) {
                    return length;
                }
            }
        }
        return length;
    }

    @Test
    public void test(){
        //String s = "I am having a good day";
        String s = "";
        System.out.println(lengthOfLastString(s));
    }
}
