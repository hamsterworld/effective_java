package effective.java.item1.staticfactory;

import effective.java.item1.staticfactory.GoodPoint345.HelloServiceInterface;

import java.util.Optional;
import java.util.ServiceLoader;

public class staticfactory {

    /**
     * 정적팩토리매서드를 고려하면 좋은점
     *
     * 1.이름을 가질수있다.
     * 2.호출될때마다 인스턴트를 새로 생성하지 않아도된다.
     * 3.반환 타입의 하위타입 객체를 반환할수있는 능력이 있다.
     * 4.입력 매개변수에따라 매번 다른클래스의 객체를 반환할수있다.
     * 5.정적 팩터리 매서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지않아도된다.
     *
     * 안좋은점
     * 상속을하려면 public이나 protected 생성하기필요하니 정적팩토리매서드만 제공
     * 정적 팩터리 매서드는 프로그래머가 찾기힘들다.
     * */
    public static void main(String[] args) {
        ServiceLoader<HelloServiceInterface> loader = ServiceLoader.load(HelloServiceInterface.class);
        Optional<HelloServiceInterface> helloServiceInterfaceOptional = loader.findFirst();
        helloServiceInterfaceOptional.ifPresent(h->{
            System.out.println(h.hello());
        });
    }
}
