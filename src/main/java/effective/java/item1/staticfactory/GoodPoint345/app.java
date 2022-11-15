package effective.java.item1.staticfactory.GoodPoint345;

public class app {

    public static void main(String[] args) {

        //interface나 추상을 제공하면
        HelloServiceInterface ko = HelloServiceInterface.of("ko");
        ko.hello();

    }

}
