package effective.java.item2.ch3;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping{
        HAM,MUSHROOM,ONION,PEPPER,SAUSAGE
    }

    final Set<Topping> toppings;

    /**
     * 1. Builder<T extends Builder>
     * 이건좀 명시적이지않다. Builder가 class인지 추상,인터페이스인지 헷갈린다.
     * 그냥 Builder의 하위자손이면 다된다는말, 구현도 포함일듯?
     *
     * 2. Builder<T extends Builder<T>>
     * 1과 2의 차이는?
     * 추상이나, 인터페이스에서 많이쓰는듯 Builder를 구현한 T에대해서 가능하다. 라고 좀더 구체적으로 명시해준것같음.
     * 아마 인터페이스가 <>있어서 표시해준거같음 원칙적으로는 이게맞다. 근데 1번처럼해도 문제는 없긴?하다....
     *
     * 3. Builder<T extends Builder<? super T>>
     * T가 Builder를 구현한놈인데 그 구현한놈의 자손도 가능하다는 말.
     *
     * 결국 중요한건 추상,인터페이스냐 class의 여부이냐 이차이가 큰듯?
     */
    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        /**
         * DayOfWeek라는 Enum을 다루는 Set으로 비어있는 Set을 반환
         * EnumSet enumSet1 = EnumSet.noneOf(DayOfWeek.class);
         *
         * 모든 DayOfWeek Enum의 값을 담고있는 Set을 반환
         * EnumSet enumSet2 = EnumSet.allOf(DayOfWeek.class);
         *
         * 왜이렇게 할까? 나중에 알아보자.
         */

        public void test(T t){
            System.out.println("안녕");
        }

        public T addTopping(Topping topping){
            /**
             * Objects.requireNonNull은 왜 사용하는걸까?
             *
             * Objects.requireNonNull(null); 첫번째 매서드는 null을 전달하면 메시지없는 NPE던진다.
             * Objects.requireNonNull(null,"null은 전달될수없습니다")
             * Objects.requireNonNull(null,() -> "null은 전달될수없습니다.") supplier가 구현한 익명함수의 return을 NPE로 던진다.
             *
             * 근데왜? 어차피 null이 들어가면 NPE가 뜨는건 똑같을텐데?
             * 첫번째 이유, Fail-Fast이다.
             * ex) method1 -> method2 -> method3에 이르러서야 NPE를 알수있다.
             *
             * 두번째 이유, 가독성이 좋다.
             *
             * 어느정도 타입방어도 해주는거같은데... 한번 확인해보는것도 좋을듯?
             *
             * Optional null일지도 모르는 값을 처리하는데 초점
             * requireNonNull 해당 참조가 null이면 즉시 개발자에게 알리는 것이 목적이다.
             */
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();

    }
    Pizza(Builder<?> builder){
        /**
         * 진짜 고대로 배껴온다.
         */
        toppings = builder.toppings.clone();
    }

}
