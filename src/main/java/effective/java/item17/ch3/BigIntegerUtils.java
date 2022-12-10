package effective.java.item17.ch3;

import java.math.BigInteger;

/**
 * BigInteger,BigDecimal 와 같이 상속이 되는 class 들이 있다.
 * 그리고 하위타입이 가변객체로 만들어졌을수도있다.
 * 그래서 우리가 파라미터로 BigInteger 로 받을때 하위타입이 들어올수있다.
 * 만약에 전달된 type 이 BigInteger 면 써도되지만 하위타입이라면?
 * BigInteger 로 다시 만들어쓴다. 그타입이 뭔지는 모르겟지만
 * 나는 BigInteger type 으로 만들어서 쓰겠다 이렇게 방어적복사도 가능하다.
 */
public class BigIntegerUtils {

    public static BigInteger safeInstance(BigInteger val){
        return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
    }
}
