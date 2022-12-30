package effective.java.item2.ch9;

import java.time.LocalDate;

public class Order {

    public void updateDeliveryDate(LocalDate deliveryDate) throws NullPointerException,IllegalArgumentException{

        if(deliveryDate.isBefore(LocalDate.now())){
            throw new NullPointerException("deliveryDate can't be Null ");

        }

        if(deliveryDate.isBefore(LocalDate.now())){
            //과거로 배송해달라고?
            throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
        }

    }

    /**
     *  IllegalArgumentException 을 쓰는 방법
     *
     *  굳이 throws IllegalArgumentException 하며 선언하는이유?
     *  이 매서드를 개발자에게 잘못된 인자가 들어가면 이런 런타임에러가 날수있다는 사실을알려주기위해서.
     *  그러나 너무 난발하면 가독성이 떨어진다.
     *
     *  checkedException 은 도대체 왜사용?
     *
     *  기본런타임에러좀 읽어보자.
     *  이름만이라도 읽어보자.
     *
     */

}
