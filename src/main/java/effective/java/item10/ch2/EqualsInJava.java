package effective.java.item10.ch2;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * 개인적으로 이거 내가봤을때, equals 문제의 대부분은
 * 상속과 관련해서 터지는것같다.
 * 특히, 상속해서 다른필드들이 추가됬을때는 equals를 완벽하게 만드는 법이 없다.
 * 그래가지고,composition 을 이용한다.
 *
 */
public class EqualsInJava {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time); //자식
        Date date = new Date(time); //부모

        System.out.println(date.equals(timestamp));
        System.out.println(timestamp.equals(date));

    }
}
