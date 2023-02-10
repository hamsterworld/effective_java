package effective.java.item44;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;

public class Test extends LinkedHashMap<String,String>{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Robert C. Martin", "Clean Code");
        map.put("Joshua Bloch", "Effective Java");

        /**
         * 일반적인 우리의 map 사용방식
         */
        for (String key : map.keySet()) {
            System.out.println("key = " + key + " value = " + map.get(key));
        }

        /**
         * Map.Entry 를 사용해보자.
         */
        for (Map.Entry<String, String> book: map.entrySet()) {
            System.out.println("key = " + book.getKey() + " value = " + book.getValue());
        }

        Test test = new Test();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            boolean b = test.removeEldestEntry(entry);
            // 함수객체는 이 map 의 인스턴스 매서드가 아니므로 size() 를 사용할수없다.
            // 그러므로, map 객체 자기자신을 넘겨주어야한다. 이를 반영하여 만든것이 아래의 interface 이다.
            // 나만의 전용 Function 도 만들어줫지만, 이는 이미 기본함수인터페이스에 정의되있으므로 굳이 만들필요없다.
            // 그리고 나만의 전용 Function 을 만드는건 매우신중해야한다. 실무에서 사용하는 대부분의 함수들은 이미 다 만들어져있다.
            BiPredicate<Map<String, String>,Map.Entry<String, String>> biPredicate = (m,e) -> m.size() > 100;
            /**
             * 만약에 LinkedHashMap 이 람다가 나온이후에 만들어졌다면 아래처럼
             * 생성자나 정적팩토리 매서드에 함수객체를 매개변수로 넣는 식으로 만들어졌을것이다.
             * 그러면 굳이 removeEldestEntry method 를 Override 해서 사용할 필요도없다.
             */
//            new LinkedHashMap<>(biPredicate);
//            LinkedHashMapFactory(biPredicate);
           System.out.println(b);
        }

    }

    // removeEldestEntry 를 재정의한다면 맵에 원소가 100개가될때까지 커지다가
    // 그이상이되면 새로운키다 더해질때마다 가장오래된 원소를 하나씩 제거한다.
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > 100;
    }


//    @Override
//    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
//        return super.removeEldestEntry(eldest);
//    }
}
/**
 * 추가 tip
 * 1. 표준함수형 인터페이스는 대부분 기본타입만 제공하므로 박싱된 기본타입은 넣어서 사용하지말자.
 *
 * 2. Comparator 는 구조적으로 BiFunction<T,U> 와 같지만
 * 살아있는이유
 * 2-1, 이름이 뭘하려는건지 너무명확하다.
 * 2-2, 구현하는쪽에서 반드시 지켜야하는 규약을 지니고있다.
 * 2-3, 비교자들을 조합하고 변환하는 유용한 디폴트매서드를 가지고있다.
 *
 * 3.
 * 함수형인터페이스를 받는 매서드의 인수가 같은위치이면 안된다.
 * 아래의 예시를 보자
 * public void hamster(Function<K,V> function){
 *     ... 구현 ...
 * };
 * public void hamster(Consumer<T> consumer){
 *     ... 구현 ...
 * }
 *
 * 이런식으로 같은 인자위치에 놓지말라는것.
 * Client 에게 불필요한 모호함만 안겨줄수있다.
 */
