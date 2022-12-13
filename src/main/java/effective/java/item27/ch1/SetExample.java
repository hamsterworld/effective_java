package effective.java.item27.ch1;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        // 이렇게 Raw 타입을 쓰면 아무타입이나 들어갈수있어서 typeSafe 하지않다.
        // 여기서 보면 노란줄이 뜨면서 컴파일 경고를 한다.
        Set names = new HashSet<>();

        Set<String> strings = new HashSet<>();

    }
}
