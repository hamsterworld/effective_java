package effective.java.item60;

import java.math.BigDecimal;

/**
 * BigDecimal 은 8가지 반올림모드로 반올림을 완벽히 제어한다.
 * 숫자가 크지않다면 int,long 을사용하라
 * 그러나 열여덟자리를 넘어가면 BigDecimal 을 사용해야한다.
 * 대신 속도가 느려진다.
 */
public class BigDecimalChange {
    // 코드 60-2 BigDecimal을 사용한 해법. 속도가 느리고 쓰기 불편하다. (356쪽)
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds);
    }
}
