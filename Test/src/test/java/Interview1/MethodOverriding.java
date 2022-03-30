package Interview1;

public class MethodOverriding {

    public void method1(String name, String age){
        System.out.println("method 1 called");
    }
}

class methodOverriding1 extends MethodOverriding{
    MethodOverriding methodOverriding = new MethodOverriding();
    public void method1(String name, String age){
        System.out.println("method 2 called");
    }
}
