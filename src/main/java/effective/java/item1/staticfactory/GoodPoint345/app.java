package effective.java.item1.staticfactory.GoodPoint345;

import java.util.Collections;
import java.util.EnumSet;

public class app {

    public static void main(String[] args) {

        HelloServiceInterface ko2 = HelloServiceInterface.of("ko");
        System.out.println(ko2.hello()); // 안녕

        HelloServiceInterface ko21 = HelloServiceInterface.of("ko2");
        System.out.println(ko21.hello()); // hello

    }

}
