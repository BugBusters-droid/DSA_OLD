import java.util.HashMap;
import java.util.Map;

public class Test {

    @org.testng.annotations.Test
    public void test(){
        String s = "venkatesh";

        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();

        for(char c : ch){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }

    }

    static final int ASCII_SIZE = 256;
    @org.testng.annotations.Test
    public void test2(){
        String str = "venkatesh";
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        System.out.println(result);
    }


}
