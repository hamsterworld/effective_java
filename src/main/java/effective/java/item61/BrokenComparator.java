package effective.java.item61;
import java.util.*;

/**
 * 박싱된타입과 박싱되지않은 타입의 차이점은 크게 3가지이다. (꼭 Integer 이런것에만 국한하지말고 박싱된 class 들에대해서 그럴수있다고 생각하자)
 *  1. 기본타입은 값만 가지고 있으나, 박싱된 타입은 식별성을 가지고있다.
 *  그래서 박싱된타입이 같은 값을 가지고있어도 다른인스턴스이므로 다르게 인식될수있다.
 *  (논리적동치성의 Value Class 와 관련된 내용인듯)
 *  2.박싱된타입은 null 을 가질수있다.
 *  3. 기본타입이 박싱된 타입보다 메모리,cpu 측면에서 훨씬더 효율적이다.
 *
 *  어쨋든 위 3가지를 생각하지않고 코딩하면 큰 문제를 일으킬수있다는점이다.
 *
 */
// 코드 61-1 잘못 구현된 비교자 - 문제를 찾아보자! (359쪽)
public class BrokenComparator {
    public static void main(String[] args) {
        // 1번의 특징으로 인해 발생한 문제
//        Comparator<Integer> naturalOrder =
//                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // 그래서 수정했다.
       // 코드 61-2 문제를 수정한 비교자 (359쪽)
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // 오토박싱
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}
