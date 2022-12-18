package effective.java.item32.ch1;

import java.util.ArrayList;
import java.util.List;

// 코드 32-3 제네릭 varargs 매개변수를 안전하게 사용하는 메서드 (195쪽)
public class FlattenWithVarargs {

    @SafeVarargs //(이 어노테이션은 가변인자가 안전하게 사용되고있다는 뜻이다.)
    // 그럼 언제 가변인자가 안전하게사용되는것일까?
    // 1. 안에다가 뭘넣는게아니라 꺼내서 쓰기만할때면 안전하다.
    // 2. lists를 밖으로 노출하면안된다. -> PickTwo 에서확인해보자
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7));
        System.out.println(flatList);
    }
}
