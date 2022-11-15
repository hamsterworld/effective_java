package effective.java.item1.Enumeration;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

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

        final EnumMap enumMap = new EnumMap<>(OrderStatus.class);
        enumMap.put(OrderStatus.PREPARING,"준비중");
        enumMap.put(OrderStatus.PREPARING,"테스트중");

        //EnumMap은 총갯수가 정해져서나온다.
        //위처럼 Key가 겹치면, 덮어씌우게된다.

        //순서도 보장된다.
        //순서를 변경하고싶다면 stream을 이용해서 comparator를 다시 정의해주면된다.

        //abstract class라서 static으로 생성시켜줘야한다.
        EnumSet<OrderStatus> set = EnumSet.allOf(OrderStatus.class);

        /**
         * Enum에서는 EnumMap과 EnumSet을 사용하는게 더좋다.
         */
        //EnumMap EnumSet

    }


    /**
     * 열거형은 싱글톤을 보장하기때문에 ==을 이용하여 비교해준다.
     */
}
