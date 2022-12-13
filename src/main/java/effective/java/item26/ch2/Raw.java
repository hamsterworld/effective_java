package effective.java.item26.ch2;

import java.util.ArrayList;
import java.util.List;

public class Raw {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        unsafeAdd(strings,Integer.valueOf(42));
        String s = strings.get(0);

    }

    // Raw 타입이 위험한이유
    // 저기서 매개변수로 넣을때 에러가나야되는데
    // 다넣고나서 꺼낼때 에러가 난다.
    // Type 안정성이 무지 부족하다는것.
    // 아래처럼 Raw 로 하면 Type 안정성을 잃엇다고 표현한다.
    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }

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
