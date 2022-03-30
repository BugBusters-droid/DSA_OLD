package Practice;

import org.testng.annotations.Test;

import java.util.Arrays;

public class AnagramsPair {


    public boolean areAnagram(String arr1, String arr2){
        char[] ch1 = arr1.toCharArray();
        char[] ch2 = arr2.toCharArray();
        if(ch1.length!=ch2.length){
            return false;
        }
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<ch1.length;i++) {
                if (ch1[i] != ch2[i]){
                    return false;
            }
        }
        return true;
    }
    public void findAllAnagrams(String[] arr, int n){
        int f=0;
        int s=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(areAnagram(arr[i], arr[j])){
                    System.out.println(arr[i]+" is anagram of "+arr[j]);
                }
            }
        }
    }
    @Test
    public void test(){
        String arr[] = {"geeksquiz", "geeksforgeeks",
                "abcd", "forgeeksgeeks",
                "zuiqkeegs"};
        int n = arr.length;
        findAllAnagrams(arr, n);
    }
}
