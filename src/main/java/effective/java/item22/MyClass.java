package effective.java.item22;

public class MyClass implements PhysicalConstants{

    public static void main(String[] args) {
        System.out.println(BOLTZMANN_CONSTANT);
        // interface 를 사용하면 위에처럼 가능하다.


        PhysicalConstants myClass = new MyClass();
        /**
         * 물론 문제없다 그러나
         * 원래의 interface 의 목적을 해한다.
         * MyClass 는 PhysicalConstants 의 타입인가?
         * 그것은 아니다. MyClass 를 위의 interface 의 타입으로 쓰기 부적절하다.
         */


        /**
         * 또 여기서 사용된 interface 는 Class 내부에서 사용되고있다.
         * 즉, Class 의 내부 정보에 해당한다.
         * 하지만 interface 를 통해 내부정보가 공개되었다.
         * 캡슐화가 깨진것.
         */
    }
}
