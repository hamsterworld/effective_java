package effective.java.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * reflection 보다는 interface 를 이용하라.
 *
 * 1. 컴파일타임 타입 검사가 주는 이점을 누릴수없다.
 *
 * 2. 리플렉션을 이용하면 코드가 지저분하고 장황해진다.
 *    - 이번예시 코드만봐도 예외만 6개, 코드가 길고 장황하고 복잡해진다.
 * 3. 성능이 떨이진다.
 *
 * 리플렉션을 사용해야한다면 인스턴스생성에만 사용하도록하자.
 * 이렇게 만든 인스턴스는 인터페이스나 상위클래스를 참조해서 사용하자.
 *
 * 리플렉션을 사용해야될때?
 * [컴파일타임에 이용할수없는 class 를 사용해야할때] 주로 리플렉션을 이용하게된다.
 * 인스턴스생성용도로만 사용하도록권장한다.
 * 또 이렇게만든 인스턴스는 interface 로 참조해 사용하자.
 * (아래 예시의 Set 처럼.)
 *
 */
public class Reflection {

    public static void main(String[] args) {

        // 클래스 객체
        Class<? extends Set<String>> cl = null;
        try{
            Class<?> hamster = Class.forName("hamster");
            cl = (Class<? extends Set<String>>) hamster;
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        Constructor<? extends Set<String>> cons = null;
        try {
            Constructor<? extends Set<String>> declaredConstructor = cl.getDeclaredConstructor();
            cons = declaredConstructor;
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }

        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (InstantiationException e) {
            System.out.println("클래스 인스턴스화 불가");
        } catch (IllegalAccessException e) {
            System.out.println("생성자에 접근불가");
        } catch (InvocationTargetException e) {
            System.out.println("생성자가 예외를 던졋습니다.");
        } catch (ClassCastException e){
            System.out.println("Set을 구현하지않은 클래스입니다.");
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }
}
