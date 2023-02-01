package effective.java.item30;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

// 제네릭 싱글톤 팩토리 패턴
public class GenericSingletonFactory1 {

//     싱글톤
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;

    // 이건된다.
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTITY_FN; // 이게 이제 헷갈리는겨
    }


    // 이건 안된다.
//    public static <T extends Number> UnaryOperator<T> identityFunction(){
//        return (UnaryOperator<T>) IDENTITY_FN;
//    }

    // 이건된다. => 아마 T 가 실제로는 <Number> 이므로 되는것같다. 이런 casting 도 일단 따로 알아두자.
    private static UnaryOperator<Number> IDENTITY_FN1 = t -> t;
        public static <T extends Number> UnaryOperator<T> identityFunction1(){
        return (UnaryOperator<T>) IDENTITY_FN1;
    }

    // 존나 신기하긴 하네.
    // 정해진게아니다. T 가 뭐가올지모르긴한다.
    // 제네릭매서드에서는 가능하다. 제네릭클래스에서도 가능할듯?
    // 그러나 외부에서 이미정해진 한정적타입은 불가능.
    private static List<Object> list;

        private static <T extends Object> List<T> test(){
            return (List<T>) list;
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

        List<String> objects = new ArrayList<>();
        List<Object> objects1 = new ArrayList<>();
//        objects1 = (List<Object>) objects;
//        objects = (List<String>) objects1;
    }

}



// item 26~ 30까지 크게 3개
// E,?,casting(T[]) 이런거