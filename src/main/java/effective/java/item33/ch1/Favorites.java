package effective.java.item33.ch1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * container 라고 한다면
 * 일반적으로 다른객체를 넣을수있는 객체를 뜻한다.
 * ex) Map, Set, Optional 등등 이런것들을 전부 container 라고도 부른다.
 * 우리가 그동안 제네릭을 만들엇던건 오로지 한타입만 가능하게했다.
 * 예를들 어서
 * Favorites<T> 선언하고나면
 * Favorites<String> 은
 * 요안에 문자열만 넣자고 하는것이나 마찬가지이다.
 *
 * 경우에 따라서는 동종 <-> 이종
 * 즉, 이종 컨테이너란 서로 다른타입을 넣을수있는 컨테이너를 뜻한다.
 *
 */
public class Favorites {
    //Class 는 제네릭클래스이다.

    private Map<Class<?>, Object> map = new HashMap<>();

    // 들어갈때 검사.
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
    }
    // @SuppressWarnings() 보다 더좋은건 확인을 하고 형변환하는것이다.
    // class 에있는 cast method 를통해서 자신의 클래스타입으로 변환할수있는지 검사할수있는 매서드를 제공한다.
    public <T> T get(Class<T> clazz) {
        return clazz.cast(this.map.get(clazz));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.put(String.class, "keesun");
        // 아래처럼 Class Raw 타입으로하면 깨뜨릴수있다.
//        favorites.put((Class)String.class, 1);
//        Integer integer = favorites.get(Integer.class);
//        favorites.put(String.class,1);
//        favorites.put(Integer.class, 2);

        // 타입을 가지고잇는 class type 은불가능
        // List.class 만 가능
        // 그래서 2개를 구분할수잇는 방법이 없다.
        // 그러나 챕터2에서 구분할수있는 법을 배웠다.
//        favorites.put(List<Integer>.class, List.of(1, 2, 3));
//        favorites.put(List<String>.class, List.of("a", "b", "c"));

//        List list = favorites.get(List.class);
//        list.forEach(System.out::println);
    }

}
