package Practice;

import org.testng.annotations.Test;

import java.util.Arrays;

public class StringAnagrams {

    public boolean isAnagram(char[] c1, char[] c2){
        int l1=c1.length;
        int l2=c2.length;

        if(l1!=l2){
            return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i=0;i<l1;i++){
            if(c1[i]!=c2[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String s1 = "listen";
        String s2 = "silent";
        if(isAnagram(s1.toCharArray(), s2.toCharArray())){
            System.out.println("Yes ! Its An anagram");
        } else{
            System.out.println("No ! Its not An Anagram");
        }
    }
}
