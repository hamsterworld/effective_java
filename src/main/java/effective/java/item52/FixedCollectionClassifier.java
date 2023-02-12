package effective.java.item52;

import java.math.BigInteger;
import java.util.*;

// 수정된 컬렉션 분류기 (314쪽)
public class FixedCollectionClassifier {
    public static String classify(Collection<?> c) {
        return c instanceof Set  ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}

/**
 * 결론 매개변수가 같은 다중정의는 만들지말자.
 * 즉, 피해야 한다.
 * 같은 개수의 인수를 다중정의하는것보다는
 * 메서드이름을 다르게 지어주는 길도 항상 열려 있다.
 * ObjectOutputStream 은 write 매서드를 다중정의가 아닌
 * 다른 이름을 지어주는 길을선택했다.
 * writeBoolean, writeInt, writeLong ...
 *
 * 생성자는 어떻게?
 * static factory 라는 대안을 활용할수있다.
 */