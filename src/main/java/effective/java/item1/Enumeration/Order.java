package effective.java.item1.Enumeration;

import java.util.Arrays;

public class Order {

    private OrderStatus orderStatus;

    /** 만약에 order말고 다른상태가 있디고생각해보자
     *  private short status; private String status; 등등..
     *  private int status;
     *  예를들어서 0-주문받음 1-준비중 2-배송중 3-배송완료
     *  또는
     *  private final int 주문받음 = 0;
     *  private final int 준비중 = 1;
     *  등등
     *  이렇게 상수로 정의할수도있다.
     *
     *  그러나 int,short에 다른 숫자가 들어가도 문제가없다.
     *  type-safe가 전혀안된다.
     *
     *  열거형을하면 이런것들이 보호가 된다.
     *
     *
     * */

    /**
     *  만약에 열거형의 모든것을 출력하라고했을때 뭘하면될까?
     *  values를 사용하면된다.
     */

    public static void main(String[] args) {
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);


        Order order = new Order();
        if(order.orderStatus == OrderStatus.DELIVERED){
            System.out.println("배달중");
        }
        //아래는 NPE가 터지지만 ==는 NPE가 터지지않는다.
        //그래서 위에가 더 선호된다.
        if(order.orderStatus.equals(OrderStatus.DELIVERED)){
            System.out.println("배달중");
        }

        /**
         * Enum에서는 EnumMap과 EnumSet을 사용하는게 더좋다.
         */
        //EnumMap EnumSet

    }


    /**
     * 열거형은 싱글톤을 보장하기때문에 ==을 이용하여 비교해준다.
     *
     */
}
