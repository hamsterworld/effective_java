package effective.java.item10.ch1;

/**
 * equals 를 언제 재정의할 필요가없는가? (책에서는 굳이 재정의할필요없다면 안하는것을 추천한다.)
 *
 * 1.인스턴스가 고유하다.
 * ex) singleton,Enum..
 *
 * 2.인스턴스의 '논리적 동치성'을 검사할 필요가 없을때.
 * 논리적 동치성이란?
 * 50달러 짜리 2개가있다고 해보자
 * 값이 같냐? 50달러면 서로같다 -->이게 논리적 동치성이다.
 * 그러나 엄연히 다른돈이다. 50달러여도.
 * 그래서 인스턴스의 동치성만으로도 충분하다면 굳이 equals 를 재정의할 필요가 없다.
 * 편하게 생각하면된다 인스턴스 2개생성하면 2개는 그냥 다른거다 이게 인스턴스의 동치성을 확인하는것.
 *
 * 3.상위클래스에서 정의한 equals 가 하위클래스에도 충분하다면.
 * 대표적으로 list,set 같은 경우..
 *
 * 4.클래스가 private 이거나 package-private 이면 equals 를 호출할 일이 없다.
 * 그냥 밖에서 마음껏 사용할수없는 class
 * 근데 public class 는
 * equals 가 호출이 안될거라는 보장을 하기가힘들다.
 * 대표적으로 list,set 같은경우에 의도치않게 사용될수있으므로.
 *
 */
public class equals {

    private class secretHamster{

    }

    public class Hamster{

    }

    private static class secretStaticHamster{

    }

    public static class staticHamster{
        staticHamster(String s){
            System.out.println(s);
        }
    }

}
