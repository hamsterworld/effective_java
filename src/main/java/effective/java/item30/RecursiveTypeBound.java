package effective.java.item30;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveTypeBound {
    // 타입을 한정한다.
    // E 는 Comparable 을 상속하거나 구현한 애만 가능하다.
    // 재귀적 타입한정이란 아래와같은것을 뜻한다. = <E extends Comparable<E>>
    // 그냥 타입한정인데 자기 자신의 타입을 한번더 썻기때문에 재귀적타입한정이라고한다.
    // 보통 comparable 일때 많이쓰이고 우리가 흔하게 볼수있는 상황은 아니다.
    // 예를들어서 String 을 보면 Comparable<String> 으로
    // 자기자신의 타입을 가지고있는 인터페이스를 구현하고있다.
    // String implements Comparable<String>
    // E extends Comparable<E>
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()){
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : c) {
            if(result == null || e.compareTo(result) > 0){
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> argList = List.of("keesun","whiteship");
        System.out.println(max(argList));
    }
}
