package effective.java.item21.ch1;

/**
 * interface 는 구현하는 쪽을 생각해서 설계하라.
 *
 * 1. 기존 인터페이스에 디폴트 매서드를 구현을 추가하는것은 위험한 일이다.
 *  - 디폴트 매서드는 구현 클래스에 대해 아무것도 모른 채 합의 없이 무작정 "삽입"될뿐이다.
 *  - 디폴트 메서드는 기존 구현체에 런타임 오류를 일으킬 수 있다.
 *
 * 2. 인터페이스를 설계할 때는 세심한 주의를 기울여야한다.
 *  - 서로 다른 방식으로 최소한 세가지는 구현을 해보자.
 *
 *  ex) Collection interface 를 보면
 *  removeIf 라는 default 매서드가 추가되었다.
 *  이는 굉장히 편리하다.
 *  그냥 추가만 하고 모두가 사용할수있으니까
 *
 *  그러나 class 관점에서보면
 *  이 interface 를 구현한 synchronized 입장에서는
 *  매우 위험하다.
 *  concurrentModificationException 이 발생할수있다.
 *  그래서 구현한 클래스에서 removeIf 를 Overriding 해야한다.
 *  우리가 만든 라이브러리야 뭐 어떤 default 가 추가됬고
 *  어떻게 Overriding 하는지 알지만
 *  3rd party 입장에서는 그게 쉽지않다.
 * https://commons.apache.org/proper/commons-collections/javadocs/api-3.2.2/index.html
 * https://commons.apache.org/proper/commons-collections/javadocs/api-4.4/index.html
 * SynchronizedCollection 한번 볼것
 * removeif 를 다시구현하고있다.
 *
 * Collection -> SynchronizedCollection
 * 인데 Collection 에 removeIf 를 추가했다.
 * 근데 얘는 lock 을사용안하는 매서드이다.
 * 그래서 SynchronizedCollection 를 구현한 인스턴스가
 * removeIf 를 사용하면 concurrentModificationException 발생할수있다는말.
 *
 * 나중에 Collections.synchronizedCollection 에 속하는 애들은
 * removeIf 를 오버라이딩해서 사용하고있긴하지만
 * JDK 에속하지않는 다른 제3자 Collection 들은 여전히 위험에 노출되있다.
 *
 * 결론, 기존 사용되는 interface 에 default method 추가는 굉장히 신중해야한다.
 * 또 interface 설계시 항상 구현하는 사람의 입장을 생각해야한다.
 */
public interface MakerInterface {

    default void hello(){
        System.out.println("hello interface");
    }

}
