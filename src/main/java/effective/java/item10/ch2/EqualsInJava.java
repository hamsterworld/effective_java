package effective.java.item10.ch2;

import java.sql.Timestamp;
import java.util.Date;

public class EqualsInJava {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time); //자식
        Date date = new Date(time); //부모

        System.out.println(date.equals(timestamp));
        System.out.println(timestamp.equals(date));

    }
}
