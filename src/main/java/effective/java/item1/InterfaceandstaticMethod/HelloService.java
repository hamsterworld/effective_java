package effective.java.item1.InterfaceandstaticMethod;

public interface HelloService {

    String hello();

    Integer hello = 10;
    static String hi() {
        prepareMessage();
        return "hi";
    }

    private static void prepareMessage() {

    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

    default String bye() {
        return "bye";
    }

}

    /**
     *  일반적으로 매서드의 정의는
     *  instance에서 사용하는 매서드일거냐
     *  아니면 static에서도 사용가능한 매서드일거냐로 나뉘어진다.
     *
     *  interface를 구현한애들도 default매서드를 가질수있게되었다.
     *  따로 구현을 안해도된다.
     *  interface에서는 접근제어가 전부 public으로 기본이여서
     *  접근제어자가 없으면 public이다.
     *
     */


    /**
     * 각 hi매서드들에 prepareMessage();를쓰는데
     * 이것마저 public으로 노출되는게싫어서
     * prepareMessage를 private static으로 변환하였다.
     * 그리고 이런 default와 private static덕분에
     * 기존의 api기능들이 풍부해졌다.
     * 자바8부터는 위에 기능들이 추가됬기때문이다.
     * interface는 public한 필드만 가질수있기때문에
     * 상수만 정의한다.
     *
     */


