package effective.java.item24;

public class OutterClass {

    private int number = 10;

    /**
     * instance field 를 사용하는 내부 class 라면
     * 비정적 class 를 사용하는것도 괜찮다.
     * 그러나 불필요하게 비정적 class 를 사용하지 말자.
     * (결론적으로 먼저 static class 로 만들어보고
     *  Outer class 의 참조가 필요로한다면 비정적 class 로 만들자.)
     *
     * 그러나 비정적 member class 는 바깥 class 의 instance 참조가 생긴다.
     * 그래서 바깥 class 의 instance 를 만들어야 사용할수있다.
     * 근데 아래처럼 psvm 마냥 생성자의생성자로 생성하는 경우는 별루없다.
     *
     * 아래처럼 사용하는 방법이 많다.
     */

    void printNumber(){
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }

    private class InnerClass{
        void doSomething(){
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OutterClass().new InnerClass();
        innerClass.doSomething();
    }

}
