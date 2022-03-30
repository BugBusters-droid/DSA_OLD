package Practice;

import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CanAttendMeeting {
    public boolean canAttendMeeting(int[][] intervals) {
        if (intervals.length == 0) {
            return false;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int startPoint2 = intervals[i][0];
            int endPoint2 = intervals[i][1];

            int[] popArray = stack.pop();
            int startPoint1 = popArray[0];
            int endPoint1 = popArray[1];

            if (endPoint1 > startPoint2) {
                return false;
            }
            stack.add(intervals[i]);
        }
        return true;
    }

    @Test(description = "meeting rooms 1")
    public void test() {
        int[][] input = {{1, 3}, {3, 6}, {15, 18}, {8, 10},};
        System.out.println(canAttendMeeting(input));
    }


    public int minMeetingRoomsRequired(int[][] meetings){
        if(meetings.length==0){
            return 0;
        }

        Arrays.sort(meetings, (a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meetings[0]);
        int meetingRoomsRequired=1;

        for(int i=1;i<meetings.length;i++){
            int startPoint2 = meetings[i][0];
            int endPoint2 = meetings[i][1];

            int[] popArray = stack.pop();
            int startPoint1 = popArray[0];
            int endPoint1 = popArray[1];

            if (startPoint2 < endPoint1) {
                meetingRoomsRequired++;
            }
            stack.add(popArray);
            stack.add(meetings[i]);

        }
        return meetingRoomsRequired;
    }


    @Test(description = "Minimum no of meeting rooms required to accomodate all meetings")
    public void minMeetingRoomsRequired(){
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {11, 18}};
        System.out.println(minMeetingRoomsRequired(input));
    }
//    public void maxMeetingsInOneRoomPossible(ArrayList<meeting> meetings){
//        Collections.sort(meetings, (a,b)->Integer.compare(a.end, b.end));
//        Stack<meeting> stack = new Stack<>();
//        stack.add(meetings.get(0));
//
//        System.out.println(meetings.get(0).pos+1);
//        for(int i=1;i<meetings.size();i++){
//            int startPoint2 = meetings.get(i).start;
//
//            meeting popArray = stack.pop();
//            int endPoint1 = popArray.end;
//
//            if (endPoint1 < startPoint2) {
//                System.out.println(meetings.get(i).pos+1);
//                stack.add(popArray);
//                stack.add(meetings.get(i));
//            } else {
//                stack.add(popArray);
//            }
//        }
//    }

    public void maxMeetingsInOneRoomPossible(int[][] meetings){
        Arrays.sort(meetings, (a,b)->Integer.compare(a[1], b[1]));
        Stack<int[]> stack = new Stack<>();
        stack.add(meetings[0]);

        System.out.print(meetings[0][2]+" ");
        for(int i=1;i<meetings.length;i++){
            int startPoint2 = meetings[i][0];

            int[] popArray = stack.pop();
            int endPoint1 = popArray[1];

            if (endPoint1 < startPoint2) {
                System.out.print(meetings[i][2]+" ");
                stack.add(popArray);
                stack.add(meetings[i]);
            } else {
                stack.add(popArray);
            }
        }
    }

    @Test(description = "Maximum meetings in one room possible")
    public void maxMeetingsInOneRoom(){
//        int s[] = { 1, 3, 0, 5, 8, 5 };
//        int f[] = { 2, 4, 6, 7, 9, 9 };
        int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        int p=1;

        int[][] input = new int[s.length][3];
        for (int i = 0; i < s.length; i++) {
            input[i][0] = s[i];
            input[i][1] = f[i];
            input[i][2] = p++;
        }
        maxMeetingsInOneRoomPossible(input);
//        ArrayList<meeting> meet = new ArrayList<>();
//        for (int i = 0; i < s.length; i++)
//            meet.add(new meeting(s[i], f[i], i));
//        maxMeetingsInOneRoomPossible(input);
    }
//    class meeting
//    {
//        int start;
//        int end;
//        int pos;
//
//        meeting(int start, int end, int pos)
//        {
//            this.start = start;
//            this.end = end;
//            this.pos = pos;
//        }
//    }
}
