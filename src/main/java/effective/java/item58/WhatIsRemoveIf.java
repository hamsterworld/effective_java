package effective.java.item58;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * removeIf 란?
 * Predicate 를 설정해줌으로써
 * 해당하는 값을 모두 날려준다.
 */
public class WhatIsRemoveIf {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<10; i++){
            list.add(3*i);
        }
        list.removeIf( i -> i%2 == 0);

        list.add(2);
        list.removeIf( i -> i%2 == 0); // If 있다면 제거한다.
        System.out.println(list);

        // removeIf 를 제공하지않는 Collections 는 사용할수없다.
        List<Integer> li = Collections.nCopies(5, 1);
        li.removeIf( i -> i%2 == 0); // 불변객체수정이므로 변할수없다 UnsupportedOperationException 이 뜰것이다.
        System.out.println(li);
    }
}
