package effective.java.item45;

import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {

        TestFunction1<String> testFunction1 = t -> t;
        String hi = testFunction1.hamster("hi");
        System.out.println(hi);

        UnaryOperator<String> sing = t-> t+"할로우";
        String 반가워 = sing.apply("반가워");
        System.out.println(반가워);

        UnaryOperator<String> identity = UnaryOperator.identity();

        TestFunction testFunction = new TestFunction() {
            @Override
            public Object hamster(Object o) {
                return null;
            }
        };

        // 조상클래스로 간다. 조상클래스를 재정의하거나.
        // interface를 구현할때 핵심임.
        TestFuncionimpl test = new TestFuncionimpl() {
            @Override
            public String toString() {
                return "테스트입니다.";
            }
        };

        System.out.println(test.toString());
        System.out.println(test.hamster(new Object()));
        itnerafe itnerafe = new itnerafe() {
            @Override
            public void test1() {
                System.out.println("전부가능");
            }

            @Override
            public void test2() {
                System.out.println("전부가능");
            }
        };
        itnerafe.test1();
        itnerafe.test2();
    }
}
