package effective.java.item1.staticfactory.GoodPoint345;

public class app {

    public static void main(String[] args) {

        // 요렇게 static factory 로 원하는대로 뽑아낼수있다.
        HelloServiceInterface ko = HelloServiceFactory.of("ko");
        ko.hello();

        // 자바8부터는 interface 로도 가능
        HelloServiceInterface ko1 = HelloServiceInterface.of("ko");
        ko1.hello();
//        EnumSet.of(10);
    }

}
