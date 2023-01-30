package effective.java.item4.ch1;


/**
 *
 *  인스턴스화를 막으려면 private 생성자를 사용해라.
 *  어떤 경우에는 인스턴스를 만들필요가 없는경우가있다.
 *  즉,인스턴스를 만드는것을 권장하지 않는경우 객체지향언어에서
 *  객체를 활용하지않는다라는것은 굉장히 이상하게 들릴수는있지만,
 *  아이러니하게 들릴수있다. 정말 간혹 그런경우가 있다.
 *  특히, 정적인메서드만가지고있는 유틸리티성 클래스들이 그렇다.
 *  helpper 성격에 utility 성클래스를 가진애들이 그렇다.
 *
 */
public class UtilityClass {


    /**
     * 이클래스는 인스턴스를 만들 수 없습니다.
     */
    private UtilityClass(){
        throw new AssertionError();
    }
    //위와같이 생성자를 막아버릴수도있다.
    //또 재밋는건 private 라고 하더라도 내부에서 만들수도있다.
    //이것을 방지하기위해 throw 를 사용할수도있다.
    //위에처럼 생성자를 쓰면안되는데 쓴거다. 라고 에러를 발생시킨다.
    //굳이 왜 못쓰는 코딩을 만들엇을까?
    //이런경우 주석을 달아주자.

    public static String hello(){
        return "Hello";
    }

    public static void main(String[] args) {
        UtilityClass.hello();
        //물론 static 을 인스턴스로 부를순있지만 권장하지않는다.

        //UtilityClass utilityClass = new UtilityClass();
        //utilityClass.hello();

        //즉 위와같은 코드는 별루 안좋은코드고 선호되지도않는다.
        //그래서 이런 위와같은 실수를 줄이기위해서 어떻게 할것인가?

        //그래서 추상클래스로 만들어보자
        //그러나 인스턴스는 만들어질수있다.

    }




}
