package effective.java.item1.staticfactory.GoodPoint345;


public interface HelloServiceInterface {

    String hello();
//    static String hamster = "안녕";
//
//    static class hamster{
//
//    }
    static HelloServiceInterface of(String lang){
        if(lang.equals("ko")){
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    private static void hamster(){

    }

    /**
     *  인터페이스에서는 접근제어자를 생략하면 public 이다.
     *  class 는 default 라는 점점
     *  그리고 staticFactory 를 만드는시점에 굳이구현체(English,Korean)가없어도된다라는말은 무엇일까?
     *  만약에 위에 구현체가 없다고 가정해보자. (static 도 지워주자.)
     *  그리고 아래를 참고
     * */

    /**
     *  ServiceLoader 라고 자바가 기본으로 제공해주는 정적팩토리매서드가 있다.
     *  HelloServiceInterface 의 구현체를 모두 가져오게된다.
     *
     *  그렇다면 굳이 위에처럼 구현하는 이유는?
     *  나는 인터페이스를 통해 코드를 짯고
     *  이 코드가 어떤구현체가올지모를때, 사용한다.
     *  대표적으로 JDBC 가 있다.
     */

}
