package Interview1;

import org.testng.annotations.Test;

public class Test19 {

    @Test
    public void test(){
        String s = "aabbbcddeeffaabbccdef";
        char[] ch = s.toCharArray();
        int count = 0;

        for(int i=0;i<s.length();i++){
            count=0;
            for (int j=i;j<s.length();j++){
                if(ch[i]==ch[j]){
                    count++;
                } else{
                    System.out.print(ch[i]+""+count);
                    i = j-1;
                    break;
                }
            }
        }
    }

    @Test
    public void test1(){
        int[] arr = {8,7,-2,3,9};
        int expectedSum = 6;
        int sum = 0;

        for (int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[i]+arr[j]==expectedSum){
                    System.out.print(arr[i]+","+arr[j]);
                    break;
                }
            }
            System.out.println();
        }
    }
}
