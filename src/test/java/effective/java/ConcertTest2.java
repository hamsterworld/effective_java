package effective.java;

import effective.java.item3.ch1.Concert;
import effective.java.item3.ch1.Concert2;
import effective.java.item3.ch1.Elvis;
import effective.java.item3.ch1.IElvisImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcertTest2 {

    @Test
    void perform(){

        Concert2 concert = new Concert2(new IElvisImpl());
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());

    }

}
