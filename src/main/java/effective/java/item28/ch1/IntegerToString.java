package effective.java.item28.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열 보다는 리스트를 사용하라.
 *
 * 배열은 공변 , 제네릭은 불공변
 * 공변 = 같이 변하다. 불공변 = 같이 변하지 않는다.
 */
public class IntegerToString {
    public static void main(String[] args) {

        // String 은 Object 를 상속하고있다.
        // 그러므로 다형성이 되므로 Object[] 이런것이 가능하다.
        // 즉, Array 는 공변이다.
        Object[] anything = new String[10];
        anything[0] = 1; // 잘못된 코딩이다. 컴파일러가 못잡음 왜냐 array 는 공변이므로.

        // List 는 불공변
        ArrayList<String> names = new ArrayList<>();
//        ArrayList<Object> objects = names;
        // generic 은 이렇게 컴파일단계에서 명시되있지만
        // 나중에 소거된다.

        // 아래 코드가 실체화되지않고 제네릭은 소멸된다.
        // 완전히 삭제되는건 아니다.
        ArrayList<String> names1 = new ArrayList<>();
        names1.add("keesun");
        String name = names1.get(0);
        System.out.println(name);

        // 위에 코드가 어떻게되냐면
        // 아래처럼 컴파일된다. 즉, 제네릭으로 변환되는 과정이 추가된다.
        List names2 = new ArrayList<>();
        names2.add("keesun");
        Object o = names2.get(0);
        String name1 = (String)o;
        System.out.println(name1);

        //그래서 재네릭과 배열을 같이 사용하지 않는다.
//        ArrayList<String>[] arrayLists = new ArrayList<String>[10];

    }
}
