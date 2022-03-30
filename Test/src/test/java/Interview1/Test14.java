package Interview1;

import org.testng.annotations.Test;

public class Test14 {

    @Test
    public void test(){

        String s = "My name is venkatesh";
        char[] ch = s.toCharArray();
        int right = s.length()-1;
        char[] result = new char[s.length()];

        for(int i=0;i<s.length();i++){
            if(ch[i]== ' '){
                result[i] = ' ';
            }
        }
        for(int i=0;i<s.length();i++){
            if(ch[i]!=' '){
               if(result[right] == ' '){
                   right--;
               }
               result[right] = ch[i];
               right--;
            }
        }
        System.out.println(result);
    }
}
