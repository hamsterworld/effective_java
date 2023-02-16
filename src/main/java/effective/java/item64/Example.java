package effective.java.item64;

import java.util.*;

/**
 * 객체는 인터페이스를 사용해 참조하라.
 * - 이말인 즉슨, 적합한 인터페이스가 있다면 매개변수뿐만아니라, 반환값, 변수,필드를 전부 인스턴스 타입으로해야한다.
 * 객체를 실제타입으로 사용하는 경우는 오직, [생성자로 생성할때]만 그래야한다.
 *
 * 일단 인터페이스를 사용하는 습관을 들이면 훨씬더 프로그램이 유연해질수있다.
 *
 * 주의점들
 *   1. 원래클래스가 인터페이스 규약이외의 특별한 기능을 제공하고
 *   주변코드가 그코드에 기대어 동작한다면 새로운 클래스도 그런 기능을 제공해야한다.
 *   LinkedHashSet 의 순서정책을 가정하고 동작하는 코드에 HashSet 을
 *   사용하면 문제가 될수있다. HashSet 은 순서를 보장하지 않기때문이다.
 *   구현타입을 바꾸는이유는? 1.성능이 더좋은게 나와서 2. 멋진 신기능 사용
 *   HashMap 사용하다가 EnumMap 을 사용하면 성능을 높일수있다.
 *   단, Key 는 Enum 만 가능하다.
 *
 *   2. 적합한 인터페이스가 없다면 클래스를 참조해야한다.
 *   대표적으로,
 *   1. VO Value Class 는 기능이 없기에 매개변수,변수,필드,반환타입으로 적합하다.
 *   2. 인터페이스에는 없는 특수한기능을 제공하는 클래스들이다.
 *   queue interface 는 comparator 가 없지만
 *   priority queue 는 comparator method 를 제공한다.
 *
 *  마지막으로 적합한 인터페이스가 없다면 클래스의 계층구조 중 필요한기능을 만족하는
 *  가장 덜 구체적인 클래스를 타입으로 사용하자.
 */
public class Example {

    public static void main(String[] args) {

        // 좋다. 타입을 interface 로 사용했다.
        Set<Object> Good = new HashSet<>();

        // 안좋다 구체적클래스 본인을 타입으로 사용했다.
        HashSet<Object> notGood = new HashSet<>();

        // interface 를 설계하면 나중에 새클래스의 생성자 혹은 다른 정적패토리만 호출해주면된다.
        LinkedHashSet<Object> Good1 = new LinkedHashSet<>();

        Queue<Object> queue = new PriorityQueue<>();
        PriorityQueue<Object> priorityQueue = new PriorityQueue<>();
//        priorityQueue.comparator();
    }

}
