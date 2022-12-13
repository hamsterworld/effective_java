package effective.java.item24;

/**
 * 멤버 class 는 되도록이면 static 으로 만들라
 * member 란 그냥 그 class 를 구성하고 있는 요소라고 생각하면 쉽다.
 */
public class OuterClass {

    private static int number = 10;

    static private class InnerClass{
        void doSomething(){
            System.out.println(number);
        }
    }

    /**
     * static member class 는 바깥과 독립적이여서
     * 아래처럼 독립적으로 만들어서 사용할수있다.
     *
     * 보통 이런건 OuterClass 와 같이 쓰이면 좋은것들이 들어간다.
     */
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }

}
