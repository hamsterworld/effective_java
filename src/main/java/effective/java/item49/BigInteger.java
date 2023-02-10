package effective.java.item49;

import java.util.Objects;

/**
 * 매개변수가 유효한지 검사하라!
 * Why?
 * 1. 예외발생 근원점 찾기가 쉽다.
 * 2. 잘못된 값을 return 하는것을 방지할수있다.
 *   2-1, 쉽게말해서 매개변수 유효성검사를 함으로써
 *   원자성을 보존해야한다. 함수형프로그래밍? 느낌이 강한거같음
 *   실패의 원자성을 어기는 결과를 낳을수있다. (item 76) => 298p 아직잘이해가안된다. 실패의 원자성?
 *
 * public 과 protected method 는 매개변수 값이 잘못됬을때 던지는 예외를 문서화 해야한다. // * @throws
 * 일반적으로 던지는 예외는 IllegalArgumentException , IndexOutOfBoundException , NullPointerException 중 하나가 될가능성이 높다.
 *
 * 매개변수에 제약을 걸수도있다.
 * BigInteger 에서는 인수가 m > 0 이여야한다.
 *
 * 결론, 매서드는 범용적으로 설계해야하나 오류를 빠르게 찾거나 , 원자성보호를 위해 유효성 검사를 넣어주는것이 좋다.
 */
public class BigInteger {

    // 그냥예시임
    public int mod(int m){
        if (m <= 0){
            throw new ArithmeticException("계수는(m)는 양수여야 합니다. " + m);
        }
        /// 로직 수행
        return m;
    }

    // 좀더 편해진 Null 검사
    public void test(Object test){
        Objects.requireNonNull(test,"전략"); // 편해진 null 검사.
    }

    //비공개 매서드(private,package-private)들은 assert 를 통해 매개변수유효성검사도 가능하다.
    private void test2(long a[],int offset,int length){
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        //... 계산수행
        System.out.println(offset+length);
    }

    /**
     * assert 는 말그대로 비공개 매서드에서 사용된다.
     * 그래서 오직 유효한값만이 넘겨질것이라고 내가 보증할수있고 그렇게 해야한다는것이다.
     * 런타임에 아무런 효과도없다.
     * 다만 assertionError 를 던진다는데 안던지는데?
     */
    private static void test3(int i){
        assert i > 0;
        System.out.println(i);
        System.out.println(i);
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger();
        bigInteger.test2(null,-3,-130);
        test3(10);
    }
}
