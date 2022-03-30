package Practice;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {


    public int [][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int startPoint2 = intervals[i][0];
            int endPoint2 = intervals[i][1];

            int[] popArray = stack.pop();
            int startPoint1 = popArray[0];
            int endPoint1 =  popArray[1];
            /**
             * 1,4
             * 2,3
             */
            int endMax = Math.max(endPoint2, endPoint1);
            /**
             * 1,3
             * 2,6
             */
            if(endPoint1>=startPoint2){
                int[] merge = new int[]{startPoint1,endMax};
                stack.add(merge);
            } else{
                stack.add(popArray);
                stack.add(intervals[i]);
            }
        }

        int[][] output = new int[stack.size()][2];
        for(int i=output.length-1; i>=0;i--){
            int[] popArray = stack.pop();
            output[i][0] = popArray[0];
            output[i][1] = popArray[1];
        }
        return output;
    }

    @Test(description = "merge intervals")
    public void test(){
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] output = merge(input);
        for(int i=0;i<output.length;i++) {
            System.out.print(output[i][0]+",");
            System.out.print(output[i][1]+"\n");
        }
    }
}
