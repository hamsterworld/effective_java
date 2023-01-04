package effective.java.item26.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 로 타입은 사용하지말아라.
 *
 * 로 타입 : List
 * 제네릭 타입 : List<E>
 * 매개변수화 타입 : List<String>
 * 타입 매개변수 : E
 * 실제 타입 매개변수 : String
 * 한정적 타입 매개 변수 : List<E extends Number>
 * 비 한정적 와일드카드 타입 : Class<?>
 * 한정적 와일드 카드 타입 : Class<? extends Annotation>
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
            System.out.println(number);
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
