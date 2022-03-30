package Interview1;

import org.apache.http.conn.routing.RouteInfo;
import org.testng.annotations.Test;

public class Test10 {

    @Test
    public void test(){
        int[] arr = {2, 3, 4, 2, 5, 4, 2, 2, 6, 7, 8};
        int count = 0;
        int length = arr.length;

        for(int i=0; i<arr.length;i++){
            arr[(arr[i])%length] +=length;
        }
        int maximumNoOfTimes = arr[0];
        int output = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maximumNoOfTimes){
                maximumNoOfTimes=arr[i];
                output=i;
            }
        }
        System.out.println(output);
    }


}
