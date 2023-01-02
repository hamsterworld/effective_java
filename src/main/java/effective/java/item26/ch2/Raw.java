package effective.java.item26.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * Raw 타입을 사용하면 안되는이유
 * 1. Type 안정성을 잃어버린다.
 * 2. 표현력을 잃어버린다.
 * 아래처럼 Strings 라는 List 에 string 만들어갈수있다는 사실을 우리는 알수있다. => 이것이 표현력이다.
 *
 * Java 에서 Raw 타입을 살려두는 이유?
 * => 하위버전 호환성을 위해서..
 */
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings,Integer.valueOf(42));
        String s = strings.get(0);

    }

    // 1. Raw Type 선언시.
    // 당연히 list 에다가 Object 를 넣을수있다.
    // 아래 코드는 넣을때 나는게 아니라 RunTime 중에 난다.
    // 또 여기서 Raw Type 과 List<Object> 에대해서 알수있다. Raw Type 은 그냥 Type 방어자체가 안된다.
    // 물론 실제 Byte Code 에서는 Raw 와 <>과는 차이가 없지만...
    // 미리 Type 에러에대해서라던지 이런것을 미리미리 방어할수있다.
    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }

    // 2. Generic Type 선언시.
    // 아래처럼 하면 위에 에러가보인다.
    // 이렇게 코드짤때 미리미리 잘못된것을 알수있다
    // 안정성 up
//    private static void unsafeAdd(List<Object> list, Object o){
//        list.add(o);
//    }

//    private static void unsafeAdd(List<String> list, String o){
//        list.add(o);
//    }
}
