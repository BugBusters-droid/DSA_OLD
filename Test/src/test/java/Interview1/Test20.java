package Interview1;

import org.testng.annotations.Test;

public class Test20 {

    // Find maximum sum of triplets in an array such than i < j < k and a[i] < a[j] < a[k]


    public int tripletSum(int[] arr) {
        int outputSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            int maximum1 = 0;
            int maximum2 = 0;
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i]) {
                    if(arr[j]>maximum1){
                        maximum1=arr[j];
                    }else{
                        maximum1=maximum1;
                    }
                    //maximum1 = Math.max(maximum1, arr[j]);
                }
            }
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] > arr[i]) {
                    if(arr[k]>maximum2){
                        maximum2=arr[k];
                    }else{
                        maximum2=maximum2;
                    }
                    //maximum2 = Math.max(maximum2, arr[k]);
                }
            }
            if (maximum1 > 0 && maximum2 > 0) {
                if(maximum1 + arr[i] + maximum2>outputSum){
                    outputSum= maximum1 + arr[i] + maximum2;
                } else{
                    outputSum = outputSum;
                }
                //outputSum = Math.max(outputSum, maximum1 + arr[i] + maximum2);
            }
        }
        return outputSum;
    }


    @Test
    public void test() {
        int[] arr = {2, 2, 2, 2, 2, 2};
        System.out.println("max sum is ::: " + tripletSum(arr));
    }

    /**
     *  System.SetProperty("webdriver.chrome.driver", "/src/main/java/jar/seleniumwebderiver.exe");
     *  WebDriver driver = new ChromeDriver();
     *
     */


    /**
     * pojo - we create pojos using lombok
     * entity - we assign all the values to pojo
     * factory - we call entity and convert it into json from oject
     * helpers - step wise api execution and return response or step wise execution for kafka/ kafka helpers/ db helpers
     * test - all the tests written step wise
     * validator - all assertions
     * dataproviders - all data providers
     * constant - all constant
     */

    @Test(dataProvider = "testData", dataProviderClass = Demo.class)
    public void demoData(String a1, String a2){

    }
}
