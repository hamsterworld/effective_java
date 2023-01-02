package effective.java.item34;


import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }

    public abstract double apply(double x, double y);

    // 코드 34-7 열거 타입용 fromString 메서드 구현하기 (216쪽)
    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    // 지정한 문자열에 해당하는 Operation 을 (존재한다면) 반환한다.
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {

        double x = Double.parseDouble("2.00");
        double y = Double.parseDouble("3.12");

        for (Operation op : Operation.values()){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        Optional<Operation> operation = Operation.fromString("+");
        operation.ifPresent(System.out::println);
        Optional<Operation> operation1 = Operation.fromString("ㅛ");
        operation1.ifPresent(System.out::println);
    }
    /**
     * 깨지기쉽다. switch-case 문. 다르게 바꿔보자
     *
     */
//    public double apply(double x, double y){
//        switch (this){
//            case PlUS: return x + y;
//            case MINUS: return x - y;
//            case TIMES: return x * y;
//            case DIVIDE: return x / y;
//        }
//        throw new AssertionError("알수없는 연산" + this);
//    }


}
