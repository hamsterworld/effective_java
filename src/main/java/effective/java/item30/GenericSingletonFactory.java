package effective.java.item30;

import java.util.function.Function;

// 제네릭 싱글톤 팩토리 패턴
public class GenericSingletonFactory {

    public static Function<String,String> stringIdentityFunction(){
        return new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
    }
    public static Function<Number,Number> integerIdentityFunction(){
        return t -> t;
    }

    public static <E> Function<E,E> hamster(){
        return t -> t;
    }


    public static void main(String[] args) {
        String[] strings = {"삼베","대마","나일론"};
        Function<String, String> stringFunction = stringIdentityFunction();
        for (String string : strings) {
            System.out.println(stringFunction.apply(string));
        }

        Number[] numbers = {1,2.0,3L};
        Function<Number, Number> numberFunction = integerIdentityFunction();
        for (Number number : numbers) {
            System.out.println(numberFunction.apply(number));
        }

        Function<Integer,Integer> s = hamster();

    }

}
