package effective.java.item3.ch6;

@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello(){
        return "Hello";
    }

}


/**
 *
 *  어노테이션없어도 매서드 하나만있어도
 *  function 으로 취급된다.
 *  어노테이션은 그냥 마킹하기 위한 용도이다.
 *  그래서만약에 매서드 한두개더 추가하면
 *  어노테이션에서 컴파일에러가 뜬다.
 *
 */