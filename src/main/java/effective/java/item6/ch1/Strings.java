package effective.java.item6.ch1;

/**
 * 불필요한 객체 생성을 피하라.
 * 1.특히, 문자열에대해서 이야기를 강조한다.
 *
 * 2.정규식, Pattern
 * 생성 비용이 비싼 객체라서 반복생성하기보다, 캐싱해서 재사용하자.
 *
 * 3.auto boxing -> 기본타입(int)을 그것과 상응되는 기본타입(Interger)로 상호변환해주는기술
 * 기본타입과 박싱된 기본타입을 섞어서 사용하면 변환하는 과정에서 불필요한 객체가 생성될수있다.
 */
public class Strings {
    public static void main(String[] args) {
        String hello = "hello";
        String hello2 = new String("hello");
        String hello3 = "hello";
        /**
         * 1번과 2번의 차이는 무엇이냐면?
         * JVM은 String Pool이라고해서 동일한 문자열에대해서는 캐싱을 해놓는데
         * new String을 사용하게되면 따로하나더 만들게되는꼴이다.
         */
        System.out.println(hello == hello2); //true
        System.out.println(hello.equals(hello2)); //false 심지어 문자열이 같지만 위에서는 다르다.
        System.out.println(hello == hello3); //true
        System.out.println(hello.equals(hello3)); //true 그래도 문자열비교는 equals로 하라고 권장되고있다.
    }
}
