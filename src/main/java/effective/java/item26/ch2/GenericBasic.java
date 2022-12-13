package effective.java.item26.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * 그럼 왜 로타입을 사용하면 안되는가?
 */
public class GenericBasic {

    public static void main(String[] args) {
        // 타입이 없이 선언하는것 로타입 = generic 이 잇음에도 선언하지않고 하는것
        List numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add("whiteship");

        // 로타입의 문제 ClassCastException 문제
        // 이제 제네릭으로 등장으로 이런걱정이 없어졋다.
        for (Object number : numbers) {
            System.out.println((Integer)number);
        }

        // Generic 등장!
        // 형변환도 필요없고 컴파일 에러도 내주고
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
//        list.add("whiteship");

        for (Object number : list) {
            System.out.println(number);
        }
    }
}
