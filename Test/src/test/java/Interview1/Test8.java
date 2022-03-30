package Interview1;

import org.testng.annotations.Test;

public class Test8 {


    /**
     * Method overloading concept
     */

    public void method1(String name, String age){
        System.out.println("method1 called :::: name is >>>"+name+"and age is >>>"+age);
    }

    public void method1(int age, String name){
        System.out.println("method2 called :::: name is >>>"+name+"and age is >>>"+age);
    }

    @Test
    public void methodOverloading(){
        method1("Venkatesh", "29");
        method1(27, "Venkatesh");
    }


    /**
     * Is Palindrome or not
     */

    public boolean isPalindrome(String s){
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
    public void palindromeOrNot(){
        System.out.println(isPalindrome("madom"));
    }


    /**
     * reverse the string
     */

    @Test
    public void reverseAString(){
        String s = "venkatesh";
        char[] ch = s.toCharArray();
        String temp = "";

        for(int i=ch.length-1;i>=0;i--){
            char c1 = ch[i];
            temp=temp+c1;
        }
        System.out.println(temp);
    }


    /**
     * method overloading
     * method overriding
     * madam - Palindrome or not
     * venkatesh - reverse/sort
     */
}
