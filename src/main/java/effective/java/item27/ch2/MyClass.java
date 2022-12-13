package effective.java.item27.ch2;

import java.util.Arrays;

@MyAnnotation
public class MyClass {
    public static void main(String[] args) {
        // Retention 에서  Runtime /  런타임 중 참고가능
        Arrays.stream(MyClass.class.getAnnotations()).forEach(System.out::println);

        // Retention 에서  Class / 런타임 중 참고불가능 (bytecode 까진 가나 메모리에 올리진 않는다?)
        Arrays.stream(MyClass.class.getAnnotations()).forEach(System.out::println);

        // Retention 에서  SOURCE / 런타임 중 참고불가능 (여기까지오면 bytecode 에서도 읽어들일수없다.)
        Arrays.stream(MyClass.class.getAnnotations()).forEach(System.out::println);
    }
}
