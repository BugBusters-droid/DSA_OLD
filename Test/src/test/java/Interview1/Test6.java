package Interview1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test6 {

    //String[] str = {"venkatesh nandan", "shweta sharma", "narendra modi"};

    public void sortLogic(ArrayList<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                String last1 = s1[1];
                String last2 = s2[1];

                String first1 = s1[0];
                String first2 = s2[0];

                if(last1.compareTo(last2) > 0){
                    return 1;
                }
                else if(last1.compareTo(last2) == 0){
                    if(first1.compareTo(first2)>0){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                else{
                    return -1;
                }
            }
        });
        System.out.println(names);
    }

    public static void main(String [] args){
        ArrayList<String> names = new ArrayList<String>();
        names.add("bca pqr");
        names.add("abc pqr");
        names.add("xyz pqr");
        names.add("aaa bbb");

        Test6 test = new Test6();
        test.sortLogic(names);
    }


    /**
     * Make my trip POM
     */




}
