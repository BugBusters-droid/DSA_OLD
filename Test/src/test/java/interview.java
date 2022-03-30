import org.testng.annotations.Test;

public class interview {

        static final int noOfChars = 256;
        static char count[] = new char[noOfChars];

        static void getCharCountArray(String str)
        {
            for (int i = 0; i < str.length(); i++)
                count[str.charAt(i)]++;
        }

        static int firstNonRepeating(String str)
        {
            getCharCountArray(str);
            int index = -1, i;

            for (i = 0; i < str.length(); i++) {
                if (count[str.charAt(i)] == 1) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        @Test
        public void test()
        {
            String str = "abcdab";
            int index = firstNonRepeating(str);
            System.out.println(index);
        }


    @Test
    public void test1() {
            String s = "abcdab";
            for(int i=0;i<s.length();i++){
                int isUniqueChar = 0;
                for(int j=0;j<s.length();j++){
                    if(s.charAt(i)==s.charAt(j)&& i!=j){
                       isUniqueChar=1;
                       break;
                    }
                }
                if(isUniqueChar==0){
                    System.out.println(s.charAt(i));
                }
            }
    }


















    }









































/** Functional test cases for booking a ola cab
 * Validate that user is able to click on "search destination" tab and able to find the destination location
 * Validate that after destination is selected various vehicles type with amount are visible such as "Auto, Prime SUV, Prime Sedan"
 * Validate that on selecting any vehicle type user is able to book a cab where cab auth OTP is visible
 * Validate that user is able to make payment via different payment gateways such as PhonePe, GooglePay etc
 * Validate that if user selects PhonePe and payment is not in that time then cash payment is only option available to user
 * Validate that user gets rating/feedback option as well on completion of the trip
 */







