package effective.java.item1.staticfactory.GoodPoint345;

public class HelloServiceFactory {

    public static HelloService of(String lang){
        if(lang.equals("ko")){
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    /**
     *  기존의 생성자를 사용했다면
     *  korean,English 만 딱 고정적으로 생성할수있었지만,
     *  static factory 를 사용한다면 유연하게 제공해줄수있다.
     *  또 이제 interface 에서도 위와같이 static 매서드를 사용할수있다.
     *  이것이 바로 static factory 의 3번째 장점 하위타입을 불러올수있다는것.
     *  그리고 staticfactory 를 만드는시점에 굳이구현체가없어도된다라는말은 무엇일까?
     * */

}
