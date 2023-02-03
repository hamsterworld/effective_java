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

//    public <T> void put(Class<T> clazz, T value) {
//        this.map.put(Objects.requireNonNull(clazz), value);
//    }
//
//    @SuppressWarnings("checked")
//    public <T> T get(Class<T> clazz) {
//        return (T) this.map.get(clazz);
//    }

    // cast 의 파라미터값이 class type 으로 cast 될수있냐를 묻는것같다.
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
    }


    public <T> T get(Class<T> clazz) {
        return clazz.cast(this.map.get(clazz));
    }

    public static void main(String[] args) {

        Favorites favorites = new Favorites();
        favorites.put(String.class,"반갑다.");
        String s = favorites.get(String.class);
        System.out.println(s);

        // 로우타입으로 공격
        Class aClass1 = Integer.class;
        System.out.println(Object.class);
        System.out.println(aClass1);
        // 형변환이지 인스턴스타입 자체가 변경되는건 아니다.
        // 앞에가 사실상 RawType Object 타입으로 왔기때문에
        // T = Object 그러므로 p <- c 이므로 당연히 가능해서 들어갈수있다.
        // 그래서 class.cast 매서드를 쓰면 class cast 는 정확한 class type 을 알고있으므로
        // RawType 으로 장난친다고해도 fail-fast 해준다.
        // p <- c 인데 자동형변환 안되냐? class RawType 의 특별한 경우라 생각하자.
        // 뒤에 오는 value 는 어쨋든 Object 는 모두의 부모이므로 p <- c 이므로 자동형변환 문제없다.
        // 그러나 사실 Integer.class 에대한 map 이였으므로 나중에 get 으로 꺼내쓸때 exception 이 발생한다.
        favorites.put((Class)Integer.class,"햄스터");
        Object o = favorites.get((Class) Integer.class);

        Integer s1 = favorites.get(Integer.class);
        System.out.println(s1);

        Class<ColorPoint> colorPointClass = ColorPoint.class;
        Class<? extends Point> aClass = new Point().getClass();
        Class<Point> aclass1 = Point.class;
//        aclass1 = aClass;
        aClass = aclass1;

//        favorites.put(ColorPoint.class,new Point());
//        favorites.put(ColorPoint.class,(ColorPoint) new Point());
        favorites.put(Point.class,new ColorPoint());
        Point point = favorites.get(Point.class);
        System.out.println(point);

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
