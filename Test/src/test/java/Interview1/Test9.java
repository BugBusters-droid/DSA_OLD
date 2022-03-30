package Interview1;

import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Test9 {


    /**
     * a = ['tea', 'tea', 'act']
     * b = ['ate', 'toe', 'acts']
     * Return array is [0, 1, -1]
     */

    @Test
    public void test(){
       String[] str1 = {"tea", "xtee", "act"};
       String[] str2 = {"ate", "aeta", "acts"};

       List lst = new ArrayList<>();

       int count = 0;

       for(int i=0;i<str1.length;i++){
           String s1 = str1[i];
           String s2 = str2[i];
            if(s1.length()!=s2.length()){
                System.out.println("-1");
                lst.add("-1");
            } else{
                char[] ch1 = s1.toCharArray();
                //char[] ch2 = s2.toCharArray();
                for(int j=0;j<s1.length();j++){
                    if(!s2.contains(String.valueOf(ch1[j]))){
                       count++;
                    }
                }
                System.out.print(count+",");
                lst.add(count);
            }
       }


       System.out.println("list output is :::: "+lst);

    }
}
