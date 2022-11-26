package effective.java.item13.treeset;


import effective.java.item13.PhoneNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * clone 은 생성자를 사용하지않고 만드므로 사실상 어떻게 만드는지 잘모른다.
 *
 * 그리고 우리는 검증작업같은것을 생성자에 넣어놓고있기때문에 사용하지못한다.
 *
 * equals 를 했을때 다를수도잇다는 모호함..
 *
 * 가변객체에 private final Entry[] buckets 같이 final 을 못쓴다.
 *
 * 생성자는 어차피 처음에 세팅해주니까 final 을 사용할수있다.
 *
 * 결론적으로는 cloneable 의 재정의는 지양하는게 맞고
 *
 * static factory pattern 이나 copy constructor 를 새로 만들어주는것도 괜찮은 방법이다.
 *
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 *
 * TreeSet 은 정렬된 컬렉션이다.
 * 정렬된 컬렉션이란 넣을때부터 정렬되서 들어간다는것이다.
 * keyword 이진탐색트리, 레드블랙트리
 */
public class TreeSetExample {

    public static void main(String[] args) {
//        TreeSet<Integer> numbers = new TreeSet<>();
//        numbers.add(10);
//        numbers.add(4);
//        numbers.add(6);
//
//        //4 , 6 , 10으로 나온다
//        //애네는 자바가 알고있는순서그러면 자바가 모르는순서라면?
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        // 자바는 natural order 를 모른다..
        // 그래서 자바가 pn을 comparable 로 캐스팅하려고한다.
        // natural order를 아는방법이 이것뿐이니까.
        // 그래서 comprable을 아래는 구현안해서 모른다.
        // comparable을 구현해서 어떻게든 natural order를 주입해주면된다.
        TreeSet<PhoneNumber> numbers = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
        Set<PhoneNumber> phoneNumbers = Collections.synchronizedSet(numbers);
        phoneNumbers.add(new PhoneNumber(123, 456, 780));
        phoneNumbers.add(new PhoneNumber(123, 456, 7890));
        phoneNumbers.add(new PhoneNumber(123, 456, 789));

        for (PhoneNumber number : numbers) {
            System.out.println(number);
        }
    }
}
