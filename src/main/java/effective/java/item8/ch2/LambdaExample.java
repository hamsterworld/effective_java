package effective.java.item8.ch2;

import java.lang.reflect.Field;

/**
 * 람다 역시 바깥객체의 참조를 갖기 쉽다.
 */
public class LambdaExample {

    private int value = 10;

    // runnable 을 이런식으로 정의해서 value 같은 필드를 람다가 참조하게되면
    // 바깥객체의 참조를 가지기 쉽다. 즉,lambda 라는 outer 의 참조를 가지게된다.
    // 우리가 원치않은 형태가 된다.
    // 즉,이런경우 우리가 정리를 원하는 outer 객체가 람다랑 서로 순환참조를 하게되기때문이다.
    // 그래서 clean 는 이렇게하면안된다.
    private Runnable instanceLambda = () ->{
        System.out.println(value); // --> 물론 바깥객체의 필드든매서드든 안쓰면 안생긴다. 주석처리하고 확인해보자.
                                   // 그러나 static 이면 참조하지않는다 바깥객체나 람다가 static 이면 아래와같은상황
    };

//    private static int staticValue = 10;
//
//    private static Runnable staticLambda = () ->{
//        System.out.println(staticValue);
//    };

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();
        Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("field type: " + declaredField.getType());
            System.out.println("field name: " + declaredField.getName());
        }
    }

}
