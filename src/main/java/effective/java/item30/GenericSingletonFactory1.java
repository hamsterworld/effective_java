package effective.java.item30;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

// 제네릭 싱글톤 팩토리 패턴
public class GenericSingletonFactory1 {

//     싱글톤
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;


        @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // 제네릭이용
//    @SuppressWarnings("unchecked")
//    public static <T> UnaryOperator<T> identityFunction(){
//        return t-> t;
//    }

    //제네릭+싱글톤 패턴이된다.
    public static void main(String[] args) {
        String[] strings = {"삼베","대마","나일론"};
        UnaryOperator<String> stringFunction = identityFunction();
        for (String string : strings) {
            System.out.println(stringFunction.apply(string));
        }

        Number[] numbers = {1,2.0,3L};
        UnaryOperator<Number> numberFunction = identityFunction();
        for (Number number : numbers) {
            System.out.println(numberFunction.apply(number));
        }

        ArrayList<Object> list = new ArrayList<>();
        list.add(new Integer(1));

    }

}
