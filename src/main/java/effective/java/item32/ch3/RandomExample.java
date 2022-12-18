package effective.java.item32.ch3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Atomic 이붙어잇느 애들은 concurrent package 에 들어있는 애들이다.
 * multi-thread 환경에서 사용되는 것중 하나이다.
 * lock 을 사용하지않고 multi thread 환경에서 안전하게 사용될수있다.
 * lock 의 단점은 누군가가 lock 을 들고 안에있으면 다른사람은 누구도 들어갈수가없다. => 성능에 많은 영향을 미친다.
 *
 * pessimistic locking 열쇠가없으면 그냥 안들어가고 열쇠를 받아야 들어가는 것
 * optimistic locking 일단 누군가있든말든 들어가보는거. 있으면 나오고 없으면 다시 도망가는 그런것
 * Atomic 은 optimistic locking 을 사용한다.
 * 좀더 구체적으로 말하면 compareAndSwap 이다.
 */
public class RandomExample {

    public static void main(String[] args) {
        // random 은 이미 thread-safe 하다.
        // 그러나 둘중하나는 무조건 실패하니까 계속 돈다. 그래서 성능에 문제가 조금있을수있다.
        Random random = new Random();
        System.out.println(random.nextInt(10));

        // 그래서 그냥 쓰레드로칼에 국한되잇는 것을 쓰자 아래처럼.
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(10));
    }

    private int value;

    // 내가 화장실을 열었는데 아무도없다 = 이전과 그대로인 상태이다. => 그러면 볼일을 본다.
    // 내가 화장실을 열었는데 아무도 있다. = 값이 변경되어있다. => 나간다. 값을 안바꾼다.
    // 그래서 원자적이다 아토믹이라는 것을 붙인거다. 처음과 끝이 같아야한다 이말인듯
    public synchronized int compareAndSwap(int expectedValue, int newValue)
    {
        int readValue = value;
        if (readValue == expectedValue)
            value = newValue;
        return readValue;
    }
}
