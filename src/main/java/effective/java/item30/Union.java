package effective.java.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * 되도록이면 제네릭메서드로 만들어라.
 *
 * 그러면 어떨때 제네릭메서드로 만들어야하는가?를 알아보자.
 */
public class Union {
    // 자바 에서 제공하는 Collections 와 같은 util 성 class 들은 모두
    // 제네릭한 class 를 제공한다.


    public static <E> Set<E> union(Set<E> s1,Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        // 2개의 Set 을 합치고 있다.
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> guys1 = Set.of("톰1", "딕1", "해리1");
        Set<Integer> stooges = Set.of(1, 2, 3);

        // 제네릭매서드를 통해서 여기다가 못넣는다.
        // 그래서 컴파일 에러가 나고있다.
        // 보다 안전하게 사용할수있다.
//        Set<String> all = union(guys, stooges);
        Set<String> all = union(guys, guys1);

        // 그러나 아래에서 문제가 발생한다.
        // 그래서 제네릭한 매서드를 활용해보자.
        for (String o : all) {
            System.out.println(o);
        }
    }
}
