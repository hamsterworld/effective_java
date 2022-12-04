package effective.java.item18.ch1;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstrumentSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
    // 여긴 6이아닌 3이 나온다.
    // 여기서는 아까처럼 sideEffect 가 발생하지않는다.
    // 아까는 addAll 을 하면 내가 Override 한 add 가 호출되면서
    // sideEffect 가 발생했었다.
    // 그러나 이렇게 Composition 으로 받아 사용하게된다면
    // addAll 은 HashSet 에서 Set interface 의 addAll 의 규격에 맞춰서
    // 구현을 해줄것이다. 그래서 내부구현이 어떻게 되던지간에 나의 Instrument 는 상관없는거다.
    // 그냥 아 addAll 은 전부다 추가해주는구나만 알고 나는 나만의것만 하면되는것
    // 캡슐화가 깨지지않는것.

    // 만약에 Set 에 새로운 매서드가 추가되면 forwarding 에서 새로 구현해달라고
    // 깨지게된다.

    // HashSet 에 추가가된다고 해도 아무상관없다.
    // interface 가 아니기때문이다.
    // 그래서 forwarding 도 깨지지않고 내가 구현한 instrumentSet 도 깨지지않는다.
    public static void main(String[] args) {
        InstrumentSet<String> s = new InstrumentSet<>(new HashSet<>());
        s.addAll(List.of("틱","윽엑","탁"));
        System.out.println(s.getAddCount());
    }
}
