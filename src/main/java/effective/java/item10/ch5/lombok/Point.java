package effective.java.item10.ch5.lombok;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 롬복도 에노테이션 프로세서를 쓰는데
 * 이 point 에다가 class 를 추가해준다.
 * 근데이렇게 기존에 있는 class 를 뜯어고치는것은 자바가 원하는 사용방식이 아니다.
 * 롬복이 해킹한것이다.
 *
 * 원래는 새로운클래스에다가 추가해야되는데
 * 컴파일된거보면
 * 기존의 클래스에다가 그냥 새로추가해버린다.
 * 정석적인 방법은 아니다.
 *
 * 자바14인가 15부터 추가된
 * record 를 이용하는 방법도있다. (아마 여러분은 11다음에 17을 쓰게될것이다.)
 *
 * 네번째방법은 인텔리제이를 이용하는것이다.
 * 단점은 지저분하다.
 *
 * 주의점.
 * 1. equals 를 구현하면 반드시 hasgcode 를 재정의해야한다. item 11에서볼것이다.
 * 2. Object 가 아닌 타입의 매개변수를 받은 equals 매서드를 선언하지말자 --> 이것은 오버라이딩이다.
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
