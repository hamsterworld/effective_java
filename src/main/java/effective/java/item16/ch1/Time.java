package effective.java.item16;

/**
 * 계속 강조하지만 package-public 은 control 이 불가능하다.
 */
public class Time {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;
    //물론 위에처럼 사용해도되지만 접근매서드를 이용한 부가적인 기능을 사용할수없다.
    //결국 접근매서드가 최고다.

    public Time(int hour, int minute) {
        if(hour < 0 || hour >= HOURS_PER_DAY){
          throw new IllegalArgumentException("Hour : " + hour);
        }
        if(minute < 0 || minute >= MINUTES_PER_HOUR){
            throw new IllegalArgumentException("Min : " +minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
