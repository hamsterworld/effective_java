package effective.java.item44;

import java.util.Map;

// 불필요한 함수형인터페이스
// 이미 비슷한게 표준함수형인터페이스로 구현되어있다.
// BiPredicate 이다.
@FunctionalInterface
public interface EldestEntryRemovalFunction<K,V> {
    boolean remove(Map<K,V> map, Map.Entry<K,V> eldest);
}
