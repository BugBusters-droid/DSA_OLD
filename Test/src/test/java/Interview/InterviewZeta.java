package Interview;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class InterviewZeta {

    public boolean isBalanced(String s){
       Deque<Character> deque = new ArrayDeque<>();

       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch=='('|| ch=='{'||ch=='['){
               deque.push(ch);
               continue;
           }

           if(deque.isEmpty()){
               return false;
           }

           char check;
           switch(ch) {
               case '}':
                   check = deque.pop();
                   if(check==')' || check==']')
                       return false;
                   break;

               case ')':
                   check =  deque.pop();
                   if(check == '}' || check == ']')
                       return false;
                   break;

               case ']':
                   check =  deque.pop();
                   if(check == ')' || check == '}')
                       return false;
                   break;
               }
           }
        return (deque.isEmpty());
    }
    @Test
    public void balancedParenthesis(){
        String s = "([{})]";
        if(isBalanced(s)){
            System.out.println("string is balanced");
        } else{
            System.out.println("string is not balanced");
        }
    }



    public void maxFrequencyOfString(String[] s){
        int l=s.length;
        int count=0;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<l;i++) {
            count=0;
            for (int j = 0; j < l; j++) {
                if (s[i] == s[j]) {
                    count++;
                    map.put(s[i], count);
                }
            }
        }
        System.out.println(map);

        int c=0;
        String s1 ="";
        for(int i=0;i<l;i++){
            if(c<map.get(s[i])){
                c = Math.max(c,map.get(s[i]));
                s1=s[i];
             }
            }
        System.out.println(s1);
    }
    @Test
    public void maxOcuranceOfString(){
        String[] s= {"abc","abc","xyz","xyz"};
        maxFrequencyOfString(s);
    }

}
