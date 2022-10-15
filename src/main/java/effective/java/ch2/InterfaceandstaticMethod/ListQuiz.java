package effective.java.ch2.InterfaceandstaticMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ListQuiz {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(40);
        numbers.add(20);
        numbers.add(3);

        System.out.println(numbers);

        Comparator<Integer> desc = new Comparator<>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Comparator<Integer> desc1 = (o1,o2) -> o2 - o1;

        Collections.sort(numbers,desc);
        Collections.sort(numbers,desc.reversed());
        Collections.sort(numbers, (o1,o2) -> o2 - o1);

        System.out.println(numbers);

    }
}
