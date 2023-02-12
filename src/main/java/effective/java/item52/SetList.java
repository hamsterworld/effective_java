package effective.java.item52;
import java.util.*;

// 이 프로그램은 무엇을 출력할까? (315-316쪽)
// 근본적으로 다르다 => 형변화할수없엇다.
// 그러나 오토박싱이 도입되면서 평화로운시대가 막을 내렸다.
// list interface 에서 object 와 int 는 근본적으로 달랏다.
// 오토박싱이 도입되면서 근본적으로 다르지 않게되었다.
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i); // set 은 다중정의된게없고 remove(Object) 뿐이다.
            list.remove(i); // remove(int index)를 선택한다.

            // 아래 2개다 같은 결과를 반환한다.
//            list.remove((Integer) i);
//            list.remove(Integer.valueOf(i));
        }
        System.out.println(set);
        System.out.println("==========");
        System.out.println(list);
    }
}
