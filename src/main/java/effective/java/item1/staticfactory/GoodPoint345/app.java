package effective.java.item1.staticfactory.GoodPoint345;


import java.util.EnumSet;

public class app {

    public static void main(String[] args) {

        //요렇게 static factory 로 원하는대로 뽑아낼수있다.
        HelloService ko = HelloServiceFactory.of("ko");

        //자바8부터는 interface로도 가능
        HelloServiceInterface ko1 = HelloServiceInterface.of("ko");
        ko1.hello();
//        EnumSet.of(10);
    }

}
