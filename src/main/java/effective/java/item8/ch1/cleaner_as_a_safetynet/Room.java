package effective.java.item8.ch1.cleaner_as_a_safetynet;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    //청소가 필요한 자원, 절대 Room을 참조해서는 안된다!
    //여기서는 num을 1로줄여주는게 cleaning 작업이라고 생각하고 로직을 만들엇다.
    private static class State implements Runnable{
        int numJunkPiles;

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }

    }
    //방의상태, cleanable과 공유한다.
    private final State state;

    //수거대상이 되면 방을 청소한다.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this,state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
