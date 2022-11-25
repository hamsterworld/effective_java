package effective.java.item10.ch2;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoint extends Point {

    //atomic은 동시성을 보장한다.
    private static final AtomicInteger counter =
            new AtomicInteger();
    public CounterPoint(int x, int y) {
        super(x,y);
        counter.incrementAndGet();
    }

    public static int numberCreated(){
        return counter.get();
    }
}
