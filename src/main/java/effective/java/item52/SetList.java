package effective.java.item52;
import java.util.*;

// 이 프로그램은 무엇을 출력할까? (315-316쪽)
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
//            list.remove(i); // remove(int index)를 선택한다.

            // 아래 2개다 같은 결과를 반환한다.
            list.remove((Integer) i);
            list.remove(Integer.valueOf(i));
        }
        System.out.println(set);
        System.out.println("==========");
        System.out.println(list);
    }
}
