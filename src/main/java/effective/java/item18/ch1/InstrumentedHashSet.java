package effective.java.item18.ch1;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 상속을 잘못사용햇다.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet(){

    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    // 첫번째,
    // 우리가 내부구현을 알아야한다 addAll 이 add method 를 부르고있다.
    // 정상적으로 사용하려면 addCount += c.size(); 를 주석처리해야된다.
    // 그래서 이렇게 상위클래스 구현을 알아야한다.
    // 근데 만약에 상위클래스 구현이 변경된다면? 어떤이유로인해 HashSet 의 addAll 의 기능이 변경된다면?
    // 그러면 우리는 그 상속받은 애들은 한번 전부 검토하거나 변경해야한다.
    // 캡슐화가 깨지게된다.

    // 두번째,
    // 우리는 Override 를 해서 추가되는 모든것에 count 하기위해 상속했는데
    // 만약에 Set 에 새로운 add 기능이 추가됫다.
    // 그러면 우리가 이 기능이 추가된걸 알고 다시 Override 해서 count 기능을 넣을수있을까?
    // 아마 불가능할것이다. 즉, 구멍이 생기게된다.
    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    // 세번째 getAddCount 를 내가 private 로놧는데
    // 나중에 HashSet 이 같은 기능을 구현하게된다면
    // 하위는 상위보다 접근지시자가 넓거나 같아야하므로 깨지게된다.
    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<Object> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱","탁틱","펑"));
        System.out.println(s.getAddCount());
    }
}
