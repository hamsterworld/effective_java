package effective.java.item21.ch2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {

    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        // 위의 2개는 다르다.
        // of 로 만든 Collection 은 immutable 한 Collection 이다.

        // 그래서 immutable 한 Collection 으로 만들어진것을
        // 수정하려한다면 UnsupportedOperation 이 발생한다.

        // for-each 로 순회를 하다 remove 를 하면
        // concurrentModificationException 이 발생한다. (싱글쓰레드임에도 불구하고)
        for (Integer number : numbers) {
            if(number == 3){
                numbers.remove(number);
            }
        }

        // 내가 직접 iterator 를 사용하면 Exception 발생하지 않는다.
        for(Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();){
            Integer integer = iterator.next();
            if(integer == 3){
                iterator.remove();
            }
        }

        // index 를 사용해도 발생하지않는다.
        for(int i = 0; i< numbers.size(); i++){
            if(numbers.get(i) == 3){
                numbers.remove(numbers.get(i));
            }
        }

        // removeIf 사용하기
        // 가장 최신 사용법
        numbers.removeIf(number -> number == 3);
        numbers.forEach(System.out::println);
    }
}
