package Practice;

import org.testng.annotations.Test;

import java.util.*;

public class TripletMultiplication {

    @Test(description = "maximum product of three integers in an array")
    public void test(){
        //int[] arr = {10, 3, 5, 6, 20};
        int[] arr = {7,3,4,8,9,2,1,4,5};
        int n= arr.length;
        int max_product=0;

        if(n<3){
            System.out.println("no triplte exists");
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    max_product = Math.max(max_product,
                            arr[i] * arr[j] * arr[k]);
                }
            }
        }
        System.out.println(max_product);
    }

    @Test
    public void test2(){
        int[] arr = {10, 3, 5, 6, 20};
        Arrays.sort(arr);
        System.out.println("Max product is ::: "+arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3]+"  and the numbers are :::"+
                arr[arr.length-1]+","+arr[arr.length-2]+","+arr[arr.length-3]);
    }

    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    @Test(description = "permutations of a string")
    public void stringPermutation(){
        String s = "ABC";
        int n= s.length();
        permute(s, 0, n-1);
    }




    static int minSwap(int arr[], int n, int k) {

        // Find count of elements which are
        // less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current
        // window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k)
                --bad;

            // Increment count of current window
            if (arr[j] > k)
                ++bad;

            // Update ans if count of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    @Test(description = "Minimum swaps required to bring all elements less than or equal to k together")
    public void minSwap(){
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwap(arr, n, k) + "\n");

        int arr1[] = {2, 7, 9, 5, 8, 7, 4};
        n = arr1.length;
        k = 5;
        System.out.print(minSwap(arr1, n, k));
    }

    @Test(description = "")
    public void unsortedSubArrayIndex(){
        int arr[] = {1,2,3,4,7,6,5,8,9,10};
        //int arr[] = {1,3,4,6,5,2,11,7,10,14,15,16};
        int leftIndex=0;
        int rightIndex=0;

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length)
                if (arr[i] > arr[i + 1]) {
                    for(int j=0;j<i+1;j++) {
                        if(arr[i+1]>arr[j]) {

                        } else{
                            leftIndex = j;
                            System.out.println(leftIndex);
                            break;
                        }
                    }
                }
        }
        for (int i = arr.length-1; i > leftIndex; i--) {
            if (i - 1 > leftIndex)
                if (arr[i] < arr[i - 1]) {
                    rightIndex = i;
                    System.out.println(rightIndex);
                    break;
                }
        }

    }


    @Test(description = "Sort even odd in an array")
    public void sortEvenOdd(){
        int[] array_sort = {5, 12, 3, 21, 8, 7, 19, 102, 201 };

        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        for (int i : array_sort) {
            if ((i % 2) != 0) {
                odd.add(i);
            } else {
                even.add(i);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        System.out.println("Odd:" + odd);
        System.out.println("Even:" + even);
    }


    static boolean isEven(int n) {
        boolean isEven = true;
        for (int i = 1; i <= n; i++)
            isEven = !isEven;
        return isEven;
    }
    @Test(description = "Sort even odd in an array")
    public void evenOddWithoutModulusFunction(){
        int n = 4;
        if(isEven(n))
            System.out.println("Even");
        else
            System.out.println("Odd");
    }

    @Test(description = "generate list of strings from all possible combinations of string")
    public void possibleListOfString(){
        String s = "ABC";

    }


    static boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening bracket, then it must be closing. So stack cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        // Check Empty Stack
        return (stack.isEmpty());
    }
    @Test(description = "Balanced brackets")
    public void balancedParenthesis(){
        String expr = "([{}])";

        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }


    static final int ASCII_SIZE = 256;
    static char getMaxOccuringChar(String str) {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i = 0; i < len; i++)
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
        return result;
    }
    @Test(description = "max occurnace of any character")
    public void maxOccuranceChar(){
        String str = "sample string";
        System.out.println("Max occurring character is " +
                getMaxOccuringChar(str));
    }


    static void getMaxOccuringString(String[] str) {

        int len = str.length;
        int cnt=0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            cnt=0;
            for(int j=0;j<len;j++){
               if(str[i]==str[j]){
                   cnt++;
                   map.put(str[i], cnt);
               }
            }
        }
        System.out.println(map);
        String s = "";
        int n = 0;
        int max=0;

        for(int i=0;i<len;i++){
            if(map.containsKey(str[i])){
               n=map.get(str[i]);
               max=Math.max(n,max);
               if(max>=n){
                   s=str[i];
               }
            }
        }
        System.out.println(s);
        System.out.println(n);

    }
    @Test(description = "max occurnace of any string")
    public void maxOccuranceString(){
        String[] str = {"abc","abd","xyz","abc","abd","abd"};
        getMaxOccuringString(str);
    }


    public static void reverse(char str[]) {
        int r = str.length - 1, l = 0;
        while (l < r) {
            // Ignore special characters
            if (!Character.isAlphabetic(str[l]))
                l++;
            else if (!Character.isAlphabetic(str[r]))
                r--;
            else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
    }
    @Test(description = "reverse a string without affecting special character")
    public void reverseWithoutSpecChar(){
        String str = "a!!!b.c.d,e'f,ghi";
        char[] charArray = str.toCharArray();

        System.out.println("Input string: " + str);
        reverse(charArray);
        String revStr = new String(charArray);

        System.out.println("Output string: " + revStr);
    }


    public boolean isPalindromePossible(String s){
        int r = s.length()-1;
        int l=0;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            } else{
                l++;
                r--;
            }
        }
        return true;
    }
    @Test(description = "palindrome can be made from particular string or not")
    public void palindromePossibleOrNot(){
        String s = "madam";
        if(isPalindromePossible(s)){
            System.out.println("Yes !! Palindrome is possible");
        } else {
            System.out.println("Oh! Palindrome is not possible");
        }
    }
}
