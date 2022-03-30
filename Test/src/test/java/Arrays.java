import org.testng.annotations.Test;

import java.util.BitSet;
import java.util.Collections;

public class Arrays {

    @Test(description = "Reverse an array")
    public void test(){
        int arr[]  = {1, 2, 3, 4, 5, 6, 7};
        int temp[] = new int[arr.length];
        int x = 0;
        for(int i=arr.length-1; i>=0; i--){
            temp[x] = arr[i];
            System.out.print(temp[x]);
            x++;
        }
    }

    @Test(description = "Rotate an array of size n by d elements: Left Rotation")
    public void test1(){
        int arr[]  = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;

        for(int x=0;x<d;x++){
            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i] = arr[i+1];
            }
            arr[n - 1] = temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }

    @Test(description = "Rotate an array of size n by d elements: Right Rotation")
    public void test2(){
        int arr[]  = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;

        for(int x=0;x<d;x++){
            int temp=arr[n-1];
            for(int i=arr.length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }

    @Test(description = "fibonacci series")
    public void test3(){
        int n1=0,n2=1,sum,i,count=10;
        System.out.print(n1+""+n2);//printing 0 and 1
        for(i=2;i<count;i++){
            sum=n1+n2;
            System.out.print(sum);
            n1=n2;
            n2=sum;
        }
    }

    public boolean isPalindrome(String s ){
        int forward = 0;
        int backward = s.length()-1;
        while(backward>forward){
            if(s.charAt(forward)!=s.charAt(backward)){
                return false;
            }
            forward++;
            backward--;
        }
        return true;
    }

    @Test(description = "Palindrome")
    public void test4(){
       String s = "racecar";
        System.out.println(isPalindrome(s));
    }

    @Test
    public void test5(){
        int A[] = {1,2,3,7,5};
        int n = 5;
        int sum =12;
        int temp[] = new int[A.length];
        int x=0;
        int tot=0;
        int y=0;

        for(int i=0;i<n;i++){
            tot = tot + A[i];
            temp[y]=A[i];
            y++;
            for(int j=i+1;j<n;j++){
                tot = tot + A[j];
                if(tot<=sum){
                    temp[y]=A[j];
                    if(tot==sum)
                    {
                        System.out.println(temp);
                    }
                } else{
                    tot=0;
                    j=n;
                    y=0;
                }
            }
        }
    }

    public void sum(int sum,int num){

    }

    @Test(description = "first missing number")
    public void test6()
    {
        int n=10;
        int A[] = {1,2,3,5,6,8,10};
        int sum = 1;
        for(int num : A){
            if(sum==num){
                sum++;
            }
        }
        System.out.println("missing number is "+sum);
    }


    @Test(description = "any missing number in an array")
    public void test7(){
        int count=10;
        int numbers[] = {2,3,6,8,10};
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int number : numbers)
        {
            bitSet.set(number - 1);
        }
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++)
        {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    @Test(description = "find duplicate numbers")
    public void test8() {
        int numbers[] = {1, 2, 3, 6, 8, 1, 10, 3, 10};
        int temp[];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j] && i != j && j > i) {
                    System.out.print(numbers[i] + ",");
                }
            }
        }
    }

    @Test(description = "mark duplicates with o")
    public void test9(){
        int numbers[] = {1, 1, 1, 1, 1, 1, 1};
        int temp[];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j] && i != j && j > i) {
                    numbers[j]=0;
                }
            }
        }
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
    }

    @Test(description = "smallest and largest number")
    public void test10() {
        int numbers[] = {2, 3, 6, 8, 1, 10, 3, 10};
        int smallest = numbers[0];
        int largest = numbers[0];

        for (int i = 0; i < numbers.length-1; i++) {
            if (largest < numbers[i + 1]) {
                largest = numbers[i + 1];
            }
            if (smallest > numbers[i + 1]) {
                smallest = numbers[i + 1];
            }
        }
        System.out.println("largest num is " + largest);
        System.out.println("smallest num is " + smallest);
    }

    @Test(description = "sum of 2 numbers equal to sum")
    public void test11() {
        int sum = 7;
        //int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
        int[] numbers = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};

        for (int i = 0; i < numbers.length; i++) {
            int first = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int second = numbers[j];
                if (first + second == sum) {
                    System.out.println(first + "," + second);
                }
            }
        }
    }


    /*static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }*/

    public void quickSort2(int[] unsorted, int low, int high){
        int i = low;
        int j = high;
        int pivot = unsorted[i + (j - i) / 2];
        while (i <= j) {
            while (unsorted[i] < pivot) {
                i++;
            }
            while (unsorted[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort2(unsorted, low, j);
        }
        if (i < high) {
            quickSort2(unsorted, i, high);
        }
    }

    @Test(description = "sort an array")
    public void test12() {
        int[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        quickSort2(unsorted, 0, unsorted.length - 1);
        for (int x = 0; x < unsorted.length; x++) {
            System.out.print(unsorted[x] + ",");
        }
    }

    @Test(description = "find intersection of two arrays")
    public void test13(){
        int[] arr1 = {1,2,3,5,6,7};
        int[] arr2 = {7,5,8,9,10,1};

        for(int i=0;i<arr1.length;i++){
            int element1= arr1[i];
            for(int j=0;j<arr2.length;j++){
                int element2 = arr2[j];
                if(element1==element2){
                    System.out.print(element1+",");
                }
            }
        }
    }

//    @Test(description = "There is an array with every element repeated twice except one. Find that element?")
//    public void test14() {
//        int[] arr = {13,16,13,14,16,17,17,14,12,11,11};
//        int uniqueNum = arr[0];
//        int temp = 0;
//        int c=0;
//        for(int i=0;i<arr.length;i++){
//            c=0;
//            for(int j=0;j<i-1;j++){
//                if(arr[i]==arr[j]){
//                    c++;
//                }
//            }
//            for(int k=i+1; k<arr.length; k++){
//                if(arr[i]==arr[k]){
//                    c++;
//                }
//            }
//            if(c==0){
//                System.out.print(arr[i]+" ");
//            }
//        }
//
////        for(int i=0;i<arr.length-1;i++){
////            int ele1 = arr[i];
////            for(int j=i+1;j<arr.length-1;j++){
////                int ele2 = arr[j];
////                if(ele1==ele2){
////                    break;
////                }
////                else if(uniqueNum==ele2){
////                    break;
////                }
////                else{
////                    temp=uniqueNum;
////                    uniqueNum=ele1;
////                }
////            }
////        }
////        System.out.println(temp);
//    }

    @Test(description = "find non repeating characters")
    public void test15(){
        //int[] arr = {13,16,13,14,16,17,17,14,12,11,11};
        int[] arr = {1,1,2,2,3,4,};
        for(int i=0;i<arr.length;i++){
            int cnt=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==arr[i]){
                    cnt++;
                }
            }
            if(cnt==1){
                System.out.println(arr[i]);
            }
        }
    }

    @Test(description = "find first non repeating characters")
    public void testFirstNonRepeatingCharacter(){
        //int[] arr = {13,16,13,14,16,17,17,14,12,11,11};
        int[] arr = {1,1,2,2,3,4,};
        for(int i=0;i<arr.length;i++){
            int cnt=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==arr[i]){
                    cnt++;
                }
            }
            if(cnt==1){
                System.out.println(arr[i]);
                break;
            }
        }
    }

    @Test(description = "find all unique elements from an array")
    public void test16(){
        int[] arr = {1,1,2,2,3,4};
        java.util.Arrays.sort(arr);
        int cur=0;
        for(int i=1;i<arr.length;i++){
            if(arr[cur]==arr[i]){
                continue;
            } else{
                cur++;
                arr[cur]=arr[i];
            }
        }
        for(int i=0;i<=cur;i++){
            System.out.println(arr[i]);
        }
    }

    @Test(description = "Kth smallest integer")
    public void test17(){
        int arr[] = {7, 2, 3, 9, 4};
        int k =2;
        java.util.Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }

    @Test(description = "Kth largest integer")
    public void test18(){
        Integer arr[] = {7, 2, 3, 9, 4};
        int k =2;
        java.util.Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr[k-1]);
    }

    @Test(description = "sort an array in descending order")
    public void test19(){
        int [] arr = new int [] {5, 2, 8, 7, 1};
        int temp = 0;

        //Displaying elements of original array
        System.out.println("Elements of original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //Sort the array in descending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println();
        //Displaying elements of array after sorting
        System.out.println("Elements of array sorted in descending order: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    @Test
    public void twoLargestNumbersWithoutUsingInBuiltSorting(){
        int[] arr = {500, 2, 800, 7, 1};
        int max1 = -1;
        int max2 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2=max1;
                max1=arr[i];
            } else if(arr[i]>max2){
                max2=arr[i];
            }
        }
        System.out.println("top two numbers are :::"+max1+","+max2);
    }

    @Test(description = "find the smallest positive integer value that cannot be represented as sum of any subset of a given array")
    public void test20(){
        int arr[] = {1, 2, 6, 10, 11, 15};
        //int arr[] = {1, 1, 1, 1};;
        int res = 1; // Initialize result

        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] > res){
                System.out.println(res);
                break;
            }
            else{
                res+=arr[i];
            }
        }
        System.out.println(res);
    }

    @Test(description = "arrange array in alternate +ve -ve integers")
    public void test21(){
        int arr[] = {1, 2, 3, -4, -1, 4};
        int temp[] = new int[arr.length];
        int x=0;

        for(int i=0;i<arr.length;i++) {
            if (String.valueOf(arr[i]).contains("-")) {
                temp[x] = arr[i];
                x++;
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        // Find the length of array
        int n =nums.length;
        // If array is empty
        if(n==0) return 0;
        // Main logic
        int i=0;int j=1;
        while(j<n){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
            else{
                j++;
            }
        }
        // index+1
        return i+1;
    }

    @Test
    public void test22(){
        int[] p = {1,1,2};
        int k = removeDuplicates(p);
        for(int i=0;i<k;i++){
            System.out.println(p[i]);
        }

    }





}








