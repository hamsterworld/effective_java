package effective.java.item5;


import effective.java.item5.ch1.SpellChecker;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private final List<String> list; // 애가 불변이다.

    public Test(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public static void main(String[] args) {

        Test test = new Test(new ArrayList<>());
        List<String> list1 = test.getList();

        System.out.println(list1.size()); // 0
        list1.add("추가할수잇지롱 ㅋㅋ");
        System.out.println(list1.size()); // 1
        list1.add("추가할수잇지롱 ㅋㅋ");
        System.out.println(list1.size()); // 2

        List<String> list2 = test.getList();
        System.out.println(list2.size()); // 0

        // 수정불가능한 collection

        for (String s : list2) {
            System.out.println(s);
        }


    }


}
