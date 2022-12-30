package effective.java.item3.ch6;

import effective.java.item3.ch5.Person2;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *  함수형 인터페이스는 람다표현식과 메소드 참조에 대한 타겟타입을 제공한다.
 *  타겟타입은 변수할당,메소드호출,타입변환에 활용할수있다.
 *  자바에서 제공하는 기본 함수형 인터페이스 익혀둘것.
 *  함수형 인터페이스를 만드는법
 *
 */
public class UsageOfFunctions {

    public static void main(String[] args) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982,7,12));
        dates.add(LocalDate.of(2002,2,3));
        dates.add(LocalDate.of(1999,11,8));

        List<Integer> before2000 = dates.stream()
                .filter(d -> d.isBefore(LocalDate.of(2000, 1, 1)))
                .map(LocalDate::getYear)
                .collect(Collectors.toList());

        System.out.println(before2000);

        Function<Integer,String> intToString = (i) -> "hello";
        Function<Integer,String> intToString1 = Objects::toString;

        Supplier<Person2> integerSupplier = () -> new Person2();
        Supplier<Person2> Person2Supplier = Person2::new; //아무것도없는 생성자를 사용한다.
        Function<LocalDate,Person2> Person2Supplier1 = (t) -> new Person2(t);
        Function<LocalDate,Person2> Person2Supplier2 = Person2::new; //Local을 받는 생성자를 사용한다.

        Consumer<Integer> integerConsumer = System.out::println; //받긴하지만 return은 없다.

        Predicate<Integer> predicate; //인자를받아서 boolean을 return한다.

        //자바에서 제공해주는 함수형 인터페이스를 꼭 알도록하자.

    }


}
