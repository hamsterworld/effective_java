package effective.java.mypractice;

import effective.java.item1.staticfactory.GoodPoint1.Product;
import org.junit.jupiter.api.Test;


class OrderTest {

    @Test
    void staticfactory(){
        Order urgentOrder = Order.urgentOrder(new Product());
        Order primeOrder = Order.primeOrder(new Product());
    }

}