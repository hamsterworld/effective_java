package effective.java.item58;
import java.util.*;

/**
 * for-each 를 사용할수없는 상황 3가지
 * 1. 파괴적인 필터링
 *    - 컬렉션을 순회하면서 선택된 원소를 제거해야한다면 iterator 의 remove method 를 호출할때 사용할수없다.
 *    - removeIf 를 사용해서 명시적으로 컬렉션을 순회하는것을 피할수있다.
 * 2. 변형
 *    - 리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야한다면 리스트의 반복자나 배열의 인덱스를 사용해야한다.
 * 3. 병렬반복
 */
// 코드 58-5 같은 버그, 다른 증상! (349쪽)
public class DiceRolls {
    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void main(String[] args) {
        // 같은 버그, 다른 증상!
        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (Iterator<Face> i = faces.iterator(); i.hasNext(); )
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); )
                System.out.println(i.next() + " " + j.next());
        // (1,1) (2,2) (3,3) (4,4) (5,5) (6,6) 만 방출하고 끝내버린다.
        System.out.println("***************************");

        // 컬렉션이나 배열의 중첩 반복을 위한 권장 관용구
        for (Face f1 : faces)
            for (Face f2 : faces)
                System.out.println(f1 + " " + f2);
    }
}
