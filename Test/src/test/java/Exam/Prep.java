package Exam;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.testng.annotations.Test;

import java.util.*;

public class Prep {

    public boolean canAttendMeeting(int[][] meeting) {
        if (meeting.length == 0) {
            return false;
        }
        Arrays.sort(meeting, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meeting[0]);

        for (int i = 1; i < meeting.length; i++) {
            int startPoint2 = meeting[i][0];
            int[] popArray = stack.pop();
            int endPoint1 = popArray[1];

            if (endPoint1 > startPoint2) {
                return false;
            }
            stack.add(meeting[i]);
        }
        return true;
    }

    @Test(description = "Can one employee attend all the meetings")
    public void test() {
        int[][] input = {{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        System.out.println(canAttendMeeting(input));
    }

    public int minMeetingRoomsRequired(int[][] meeting) {
        if (meeting.length == 0) {
            return 0;
        }
        Arrays.sort(meeting, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meeting[0]);

        int meetingRooms = 1;

        for (int i = 1; i < meeting.length; i++) {
            int startPoint2 = meeting[i][0];
            int[] popArray = stack.pop();
            int endPoint1 = popArray[1];

            if (endPoint1 > startPoint2) {
                meetingRooms++;
            }
            stack.add(popArray);
            stack.add(meeting[i]);
        }
        return meetingRooms;
    }

    @Test(description = "Minimum no of meeting rooms required to accomodate all meetings")
    public void minMeetingRoomsRequired() {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {11, 18}};
        System.out.println(minMeetingRoomsRequired(input));
    }

    public void maxMeetingsInOneRoomPossible(int[][] meeting) {
        Arrays.sort(meeting, (a, b) -> Integer.compare(a[1], b[1]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meeting[0]);

        System.out.print(meeting[0][2]);
        for (int i = 1; i < meeting.length; i++) {
            int startPoint2 = meeting[i][0];
            int[] popArray = stack.pop();
            int endPoint1 = popArray[1];
            if (startPoint2 > endPoint1) {
                System.out.print("," + meeting[i][2]);
                stack.add(meeting[i]);
            } else {
                stack.add(popArray);
            }
        }
    }

    @Test(description = "Maximum meetings in one room possible")
    public void maxMeetingsInOneRoom() {
        int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        int p = 1;

        int[][] input = new int[s.length][3];
        for (int i = 0; i < s.length; i++) {
            input[i][0] = s[i];
            input[i][1] = f[i];
            input[i][2] = p++;
        }
        maxMeetingsInOneRoomPossible(input);
    }


    public int[][] mergeIntervals(int [][] meeting){
        Arrays.sort(meeting, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meeting[0]);

        for(int i=1;i<meeting.length;i++){
            int startPoint2 = meeting[i][0];
            int endPoint2 = meeting[i][1];
            int[] popArray = stack.pop();
            int startPoint1 = popArray[0];
            int endPoint1 = popArray[1];

            int endMax = Math.max(endPoint1,endPoint2);

            if(startPoint2<endPoint1){
                int[] merge = new int[]{startPoint1,endMax};
                stack.add(merge);
            } else{
                stack.add(popArray);
                stack.add(meeting[i]);
            }
        }
        int[][] output = new int[stack.size()][2];
        for(int i=0;i<stack.size();i++){
            int[] popArray = stack.pop();
            output[i][0] = popArray[0];
            output[i][1] = popArray[1];
        }
        return output;
    }

    @Test(description = "merge intervals")
    public void mergeIntervals(){
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] output = mergeIntervals(input);
        for(int i=0;i<output.length;i++) {
            System.out.print(output[i][0]+",");
            System.out.print(output[i][1]+"\n");
        }
    }


    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    @Test
    public void palindromeFromAnString() {
        String s = "1314131";
        if (isPalindrome(s)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    public String reverse(char[] ch) {
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            if (!Character.isAlphabetic(ch[l])) {
                l++;
            } else if (!Character.isAlphabetic(ch[r])) {
                r--;
            } else {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return new String(ch);
    }

    @Test
    public void reverseAStringWithoutSplChar() {
        String s = "venk#t@es%h";
        char[] ch = s.toCharArray();
        System.out.println("Before reversing ::: " + s);
        String out = reverse(ch);
        System.out.println("After reversing ::: " + out);
    }


    public void findUnsortedSubArray(int[] array, int size) {
        int i, left, right, min, max;
        /* traverse from left to right and find first element which is greater than next element */
        for (left = 0; left < size - 1; left++) {
            if (array[left] > array[left + 1])
                break;
        }
        /* If left == size-1, then whole array is already sorted */
        if (left == size - 1) {
            System.out.println("Array is already sorted");
        }
        /* traverse from right to left and find first element which is smaller than next element */
        for (right = size - 1; right > 0; right--) {
            if (array[right] < array[right - 1])
                break;
        }
        /* Now find the maximum and minimum element of sub array from index left to right */
        max = array[left];
        min = array[right];
        for (i = left + 1; i <= right; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }
        /* Traverse from right to left and find first element which is smaller than max */
        for (i = size - 1; i >= right + 1; i--) {
            if (array[i] < max) {
                right = i;
                break;
            }
        }
        /* Traverse from left to right and find first element which is greater than min */
        for (i = 0; i < left; i++) {
            if (array[i] > min) {
                left = i;
                break;
            }
        }
        System.out.println(left + "," + right);
    }

    @Test(description = "")
    public void unsortedSubArrayIndex() {
        int array[] = {1, 3, 4, 6, 5, 2, 11, 7, 10, 14, 15, 16};
        findUnsortedSubArray(array, 12);
        /**
         * 1. Traverse from left to right and find the left index where left+1<left
         * 2. Traverse from right to left and find the right element index where right-1>right
         * 3. Traverse in between left and right index to find max value and min value of elements in subarray
         * 4. Traverse from right to left and find first element which is smaller than max
         * 5. Traverse from left to right and find first element which is greater than min
         */
    }

    @Test
    public void maxProductsOfThreeIntegersInAnArray(){
        int prod=0;
        int[] arr = {7,3,4,8,9,2,1,4,5};

        for(int i=0;i< arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k =j+1;k<arr.length;k++){
                    prod=Math.max(prod, arr[k]*arr[j]*arr[i]);
                }
            }
        }
        System.out.println(prod);
    }

    public String swap(String s,int i,int j){
        char[] ch = s.toCharArray();
        char temp;
        temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);
    }
    public void permute(String s,int l,int r){
        if(l==r){
            System.out.println(s);
        } else{
            for(int i=l;i<=r;i++){
                s=swap(s,l,i);
                permute(s,l+1,r);
                s=swap(s,l,i);
            }
        }
    }
    @Test
    public void stringPermutation(){
        String s = "ABC";
        int l=0;
        int r=s.length()-1;
        permute(s,l,r);
    }

    public int minSwap(int[] arr, int n, int k){
        //find out the elements less than k
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                ++count;
            }
        }
        //find bad elements in current window
        int bad=0;
        for(int i=0;i<count;i++){
            if(arr[i]>k){
                ++bad;
            }
        }
        int ans=bad;
        for(int i=0, j = count;j<n; ++i, ++j){
            if (arr[i] > k) {--bad;}
            if (arr[j] > k) {++bad;}
            ans=Math.min(bad,ans);
        }
        return ans;
    }
    @Test
    public void minSwapsRequiredToBringAllElementLessThanK()
    {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwap(arr, n, k) + "\n");

        int arr1[] = {2, 7, 9, 5, 8, 7, 4};
        n = arr1.length;
        k = 5;
        System.out.print(minSwap(arr1, n, k));
        /**
         * 1. Find out the elements count less than or equal to k
         * 2. Find out the bad elements in current window of size k
         * 3. Now, start a loop with i=0 and j=count,j<n and decrement count of previous window for elements>k
         * 4. Increment count of J window if elements>k
         */
    }

    @Test
    public void sortEvenOddArray(){
        int[] array_sort = {5, 12, 3, 21, 8, 7, 19, 102, 201 };
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();

        for(int i:array_sort){
            if((i%2)!=0){
                odd.add(i);
            }else{
                even.add(i);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        System.out.println(odd);
        System.out.println(even);
    }

    @Test
    public void isEvenOddWithoutModulus(){
        long n=21;
        boolean isEven=true;
        for(int i=1;i<=n;i++){
            isEven=!isEven;
        }
        System.out.println(isEven);
    }


    public boolean isBalanced(String expression){
       Deque<Character> deque = new ArrayDeque();
       for(int i=0;i<expression.length();i++){
           char ch = expression.charAt(i);
           if(ch=='(' || ch=='{' || ch=='['){
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
                   if (check == ')' || check == ']')
                       return false;
                   break;

               case ')':
                   check = deque.pop();
                   if (check == '}' || check == ']')
                       return false;
                   break;

               case ']':
                   check = deque.pop();
                   if (check == ')' || check == '}')
                       return false;
                   break;
           }
       }
        return (deque.isEmpty());
    }
    @Test
    public void isBracketsBalanced(){
        String expr = "([{}])";
        if(isBalanced(expr)){
            System.out.println("balanced");
        } else{
            System.out.println("not balanced");
        }
    }



}
