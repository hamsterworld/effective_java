package effective.java.item31.ch2;


import effective.java.item31.ch2.exmaple.Box;
import effective.java.item31.ch2.exmaple.IntegerBox;
import effective.java.item31.ch2.exmaple.IntegerBox1;

import java.util.ArrayList;
import java.util.List;

// 와일드카드 타입을 사용해 재귀적 타입 한정을 다듬었다. (187쪽)
public class RecursiveTypeBound {
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
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

    public static void main(String[] args) {
        List<IntegerBox> list = new ArrayList<>();
        list.add(new IntegerBox(10, "keesun"));
        list.add(new IntegerBox(2, "whiteship"));

        System.out.println(max(list));

        // public static <E extends Comparable<E>> E max(List<? extends E> list)
        // 결국 <? extends E> 란
        // List<?> 들어온 누군가가 자기자신을 구현한 Comparable 을 구현하고 있어야한다.
        // 근데 만약에 들어온 ? 애가 구현안했다? 그때 E 가 신기한게
        // 상위클래스를 뒤져보고 거기서 구현한 애가있으면 그 E 를 return 한다.
        // 여기서 IntegerBox 는 Comparable 을 구현하지않았으므로 조건에 충족하지못해서 안된다.
        // 그러나 ? extends E 가들어가게되면 IntegerBox 의 부모인 Box 는 구현했으므로 충족
        // 그리고 Box 의 자식인 IntegerBox 가 type 으로들어왔으니 만족하게된다.
        Box<Integer> max = max(list);

        // public static <E extends Comparable<? super E>> E max(List<E> list)
        // Comparable 에서 E 의 상위클래스중에 Comparable 을 구현한 놈이 있으므로. (Box)
        // IntegerBox 가 충분히 가능하다.
        IntegerBox max2 = max(list);

        // public static <E extends Comparable<? super E>> E max(List<? extends E> list)
        // 개인적인 생각으로 ? extends E 는 굳이 필요할까 싶기도하다.
        // 여기서는 comparable 로 비교만하고 빼주는거기때문.
        // 그래도 PECS 원칙은 꼭 알아두도록하자.
        IntegerBox max3 = max(list);


        List<IntegerBox1> list1 = new ArrayList<>();
        list1.add(new IntegerBox1(10, "ergergre"));
        list1.add(new IntegerBox1(2, "whiteship"));

        System.out.println(max(list1));
        Box<Integer> max1 = max(list1);

        ArrayList<Box<Integer>> list2 = new ArrayList<>();
        list2.add(new Box<>(10));
        list2.add(new Box<>(2));

        System.out.println(max(list2));

    }
}
