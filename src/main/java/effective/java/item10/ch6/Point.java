package effective.java.item10.ch6;


import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Value Class 란?
 * class 처럼 생겼지만 이런 Point Class 마냥
 * Address Class (나라, 지역구, 아파트), Name Class(first name, middle name, last name)..등등과같이
 * Value Object 로 표현되는 애들
 * class 형태지만 그안에 들어있는 value 로 비교하는 애들을 뜻한다.
 *
 * Value based class 는 어떻게 만들까?
 * 이 Point 처럼 value 를 final 로 박아버리고 immutable 하게 만들어버린다.
 * equals, hashcode
 *
 * 이러면 value class or value based class 가 되는것이다.
 * 주의점은 객체 value 에 id 값이 들어가면안된다.
 * 즉, class 를 구분하는 고유한 id 값으로써(식별자) equals 를 구분한다던지 하면안된다.
 * value class 는 Point 처럼 x,y 값이 같으면 같다고 보는것이다.
 *
 */
@EqualsAndHashCode
@ToString
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
