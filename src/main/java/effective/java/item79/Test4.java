package effective.java.item79;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        List<Integer> snapShot = new ArrayList<>(list);
        for (Integer integer : snapShot) {
            System.out.println(integer);
            if(integer == 5) snapShot.remove(4);
        }


    }


}
