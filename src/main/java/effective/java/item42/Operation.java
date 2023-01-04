package effective.java.item42;

import java.util.function.DoubleBinaryOperator;

// 코드 42-4 함수 객체(람다)를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입 (256-257쪽)
public enum Operation {
    PLUS  ("+", (x, y) -> x + y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override public String toString() { return symbol; }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    // 아이템 34의 메인 메서드 (215쪽)
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}

// 람다가 길어지면 가독성이 떨어진다 3줄안에 끝낼수있게한다. 그이상이된다며 다른방향으로 리펙토링하는것을 추천한다.
// 람다는 문서화도 안된다.
// 람다를 직렬화하는 일은 극히 삼가야해야한다 => 사실상 하지말라는것
// 추상클래스의 인스턴스를 만들때는 람다를 사용할수없어서 익명클래스를 써야한다.
// 내부람다에대한 참조는 전에도 공부햇던거같은데 찾아보자.
// 람다는 함수형 인터페이스에서만 쓰인다.
