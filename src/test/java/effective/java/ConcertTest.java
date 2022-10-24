package effective.java;

import effective.java.item3.ch1.Concert;
import effective.java.item3.ch1.Elvis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcertTest {

    @Test
    void perform(){
        Concert concert = new Concert(Elvis.Instance);
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());


    }

}
