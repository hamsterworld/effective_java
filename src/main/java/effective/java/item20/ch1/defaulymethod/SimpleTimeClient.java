package effective.java.item20.ch1.defaulymethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// interface 는 mix-in 이 가능한데 그냥 말그대로 implements A, B 이렇게 하는거
// extends 는 하나밖에 상속못하니 힘들다.
public class SimpleTimeClient implements TimeClient,AutoCloseable{

    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(dateToSet,currentTime);
    }

    @Override
    public void setDateAndTime(int day, int month, int year,
                               int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(dateToSet,timeToSet);
    }


    @Override
    public String toString() {
        return "SimpleTimeClient{" +
                "dateAndTime=" + dateAndTime +
                '}';
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    public static void main(String[] args) {
        SimpleTimeClient myTimeClient = new SimpleTimeClient();
        System.out.println(myTimeClient);
        System.out.println(myTimeClient.getZonedDateTime("America/Los_Angeles"));
        //이런식으로도 static 사용가능
        TimeClient.getZonedId("America/Los_Angeles");
    }

    @Override
    public void close() throws Exception {
        System.out.println("clean up");
    }
}
