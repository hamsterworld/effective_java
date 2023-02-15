package effective.java.item62;

/**
 * 문자열은 권한을 구분하기에 적절하지않다.
 * 예전에 threadLocal 에서 thread 의 값을 구분하기위해
 * String 을 사용했다.
 * 그러면 고유한 키값을 제공해야한다.
 * 그러나 의사소통의 부재로 의도치않게 같은 키를 사용한다면
 * 의도치않게 변수가 공유되고 두 클라이언트모두 제대로된 기능을 사용할수없다.
 * 또한 악의적인 클라이언트가 의도적으로 같은키를 사용하게해서 다른클라이언트의 값을 가져올수도있다.
 */
public class ThreadLocal {
    private ThreadLocal() {} //객체 생성 불가

    // 현 스레드의 값을 키로 구분해 저장한다.
//    public static void set(String key, Object value);
//
//    // (키가 가르키는) 현 스레드의 값을 반환한다.
//    public static Object get(String key);
    //=======================================

    public static class Key{
        Key(){ }
    }
    public static Key getKey(){
        return new Key();
    }

//    public static void set(String key, Object value);
//
//    // (키가 가르키는) 현 스레드의 값을 반환한다.
//    public static Object get(String key);


}


//final class GoodThreadLocal {
//    public GoodThreadLocal(){
//
//    }
////    public void set(Object value);
////    public Object get();
//}

// 최종버전
final class GoodThreadLocal<T> {
    public GoodThreadLocal(){

    }
//    public void set(T value);
//    public T get();
}