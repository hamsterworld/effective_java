package effective.java.item32.ch1;

import java.util.ArrayList;
import java.util.List;

// 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. (191-192쪽)
public class Dangerous {
    // 코드 32-1 제네릭과 varargs 를 혼용하면 타입 안전성이 깨진다! (191-192쪽)
    // 아래처럼 varargs 와 제네릭을 쓰면 문제가 생긴다.

    // 가변인자로 사용된 제네릭으로인해 heap 이 오염될수있다고
    // 아래처럼 경고가 뜬다.
    static void dangerous(List<String>... stringLists) {
        // List<String>[]; compile 가 이런것을 허용하지않는다.
        // ArrayList<String>[] myList = new ArrayList<String>[10];
        // 그러나 java compile 내부에서는 본인이 스스로 만들수는 있다.

        List<Integer> intList = List.of(42);
        // 문자열의 배열은 Object[]에 할당할수있다 왜 배열은 공변이니까.
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생 (힙오염이 컴파일에서는 못잡지만 런타임에서 에러가 터지는 상황인듯?)
        String s = stringLists[0].get(0); // ClassCastException
    }

    static void aVoid(String... strings){
        String[] strings1 = strings;
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
