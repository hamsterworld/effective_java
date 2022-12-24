package effective.java.item31.ch2;


import effective.java.item31.ch2.exmaple.Box;
import effective.java.item31.ch2.exmaple.IntegerBox;
import effective.java.item31.ch2.exmaple.IntegerBox1;

import java.util.ArrayList;
import java.util.List;

// 와일드카드 타입을 사용해 재귀적 타입 한정을 다듬었다. (187쪽)
public class RecursiveTypeBound {

    // static method 는 거이 generic method 에서만 사용되는듯?
    // static 에서 PECS 는 개인적으로 필요가 없다고 생각한다.
    public static <E extends Comparable<? super E>> E max(List<E> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException("빈 리스트");
        }

        E result = null;
        for (E e : list){
            if (result == null || e.compareTo(result) > 0){
                result = e;
            }
        }

        return result;
    }

    public static <T> T test(T t){
        return t;
    }

    public static void main(String[] args) {

        String test1 = test("안녕");
//        String test2 = test(new Object());
        Object test3 = test(new Object());

        List<Box<Integer>> list4 = new ArrayList<>();
        list4.add(new IntegerBox(10, "keesun"));
        list4.add(new IntegerBox(2, "whiteship"));
        List<IntegerBox> list = new ArrayList<>();
        list.add(new IntegerBox(10, "keesun"));
        list.add(new IntegerBox(2, "whiteship"));
        List<Integer> objects = new ArrayList<>();

        // public static <E extends Comparable<E>> E max(List<? extends E> list)
        // 결국 <? extends E> 란
        // List<?> 들어온 누군가가 자기자신을 구현한 Comparable 을 구현하고 있어야한다.
        // 근데 만약에 들어온 ? 애가 구현안했다? 그때 E 가 신기한게
        // 상위클래스를 뒤져보고 거기서 구현한 애가있으면 그 E 를 return 한다.
        // 여기서 IntegerBox 는 Comparable 을 구현하지않았으므로 조건에 충족하지못해서 안된다.
        // 그러나 ? extends E 가들어가게되면 IntegerBox 의 부모인 Box 는 구현했으므로 충족
        // 그리고 Box 의 자식인 IntegerBox 가 type 으로들어왔으니 만족하게된다.
        Box<Integer> kkkkkk = max(list); //<? super E> 때문에 가능한듯.
        Box<Integer> max4 = max(list4);
//        Box<Integer> max5 = max(objects);
        System.out.println(max4);
//        Box<Integer> max = max(list);

        // public static <E extends Comparable<? super E>> E max(List<E> list)
        // Comparable 에서 E 의 상위클래스중에 Comparable 을 구현한 놈이 있으므로. (Box)
        // IntegerBox 가 충분히 가능하다.
//        IntegerBox max2 = max(list);
        Box<Integer> max2 = max(list);
//        IntegerBox max5 = max(list4);

        // public static <E extends Comparable<? super E>> E max(List<? extends E> list)
        IntegerBox max3 = max(list);

        // 개인적으로 여전히 <? extends E> 는 필요가 없는듯.

    }
}
