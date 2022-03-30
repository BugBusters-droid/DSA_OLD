package Interview1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    @Test
    public void test(){
        List lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(4);

        List lst1 = new ArrayList();
        lst1.add(1);
        lst1.add(3);
        lst1.add(4);

        List lst2 = new ArrayList();
        for(int i=0;i<lst.size();i++){
            lst2.add(lst.get(i));
            lst2.add(lst1.get(i));
        }

        System.out.println(lst2);
    }

}
