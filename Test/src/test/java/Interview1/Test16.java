package Interview1;

import org.testng.annotations.Test;

public class Test16 {

    @Test
    public void test(){

        String s = "hello";
        int left = 0;
        int right = s.length()-1;
        char[] ch = s.toCharArray();
        String output = "";

        while(left<right){
            if(ch[left]=='a' || ch[left]=='e' || ch[left]=='i' || ch[left]=='o' || ch[left]=='u'){

                left++;
                right--;
            }
        }
        System.out.println(output);

    }
}
