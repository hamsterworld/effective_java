package effective.java.item20.ch1.defaulymethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * abstract class 보다는 interface 를 만들어라.
 *
 * interface 도 결국에는 시간이 지날수록, 변경이 되고싶을때가 있다.
 * 그럴때 사용할수있는것이 default method 이다.
 */
public interface TimeClient {

    void setTime(int hour,int minute,int second);
    void setDate(int day,int month,int year);
    void setDateAndTime(int day,int month,int year,
                        int hour,int minute,int second);

    LocalDateTime getLocalDateTime();

    /**
     *  version up 이 되서 추가적인 method 가 아래처럼 추가되야할때
     *  추가 하면된다.
     *  그리고 TimeClient 가  모든 code 를 control 하고있는 상황이라면
     *  크게 문제가 되지않는다.
     *
     *  즉, package-private 라면 뭐 크게 문제 될건 없긴하다.
     *  그러나 public 한 interface 라면?
     *
     *  외부에서 구현하고 있는 모든 code 가 전부 compile error 가 나오게된다.
     *
     *  그럼이제 default 를 제공해보자.
     *  또 static 도 제공이 가능하다.
     *
     *  그래서 아래처럼 기능을 추가하면
     *  interface 를 구현한쪽에서 전혀 깨지지 않는다.
     *
     *  but field 관련해서는 추상클래스를 사용할수밖에 없다.
     *  (위에 말을 다시풀면 default method, static method 가 필드를 필요로 하는것이라면 abstract class 를 고려해야한다.)
     */

     // 신기한게 다른 package 에서도 구현만되면 사용될수있다.
     // 즉, 진짜 구현한것마냥 사용이 가능
     default ZonedDateTime getZonedDateTime(String zoneString){
         return ZonedDateTime.of(getLocalDateTime(),getZonedId(zoneString));
     };

     static ZoneId getZonedId(String zoneString){
        try{
            return ZoneId.of(zoneString);
        } catch (DateTimeException e){
            System.err.println("잘못된 문자열" + e.getMessage());
            return ZoneId.systemDefault();
        }
     };
}
