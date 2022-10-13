package effective.java.ch2.staticfactory.GoodPoint345;

import java.util.Optional;
import java.util.ServiceLoader;

public interface HelloServiceInterface {

    String hello();

//    static HelloServiceInterface of(String lang){
//        if(lang.equals("ko")){
//            return new KoreanHelloService();
//        } else {
//            return new EnglishHelloService();
//        }
//    }

    /**
     *  인터페이스에서는 접근제어자를 생략하면 public이다.
     *  class는 default라는 점점
     *  그리고 staticfactory를 만드는시점에 굳이구현체(English,Korean)가없어도된다라는말은 무엇일까?
     *  만약에 위에 구현체가 없다고 가정해보자. (static도 지워주자.)
     *  그리고 아래를 참고
     * */



    /**
     *  ServiceLoader라고 자바가 기본으로 제공해주는 정적팩토리매서드가 있다.
     *  HelloServiceInterface의 구현체를 모두 가져오게된다.
     *
     *  그렇다면 굳이 위에처럼 구현하는 이유는?
     *  나는 인터페이스를 통해 코드를 짯고
     *  이 코드가 어떤구현체가올지모를때, 사용한다.
     *  대표적으로 JDBC가 있다.
     *
     */

}
