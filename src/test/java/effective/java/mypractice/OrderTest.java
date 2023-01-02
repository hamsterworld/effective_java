package effective.java.mypractice;

import effective.java.item1.staticfactory.GoodPoint1.Product;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


class OrderTest {

    @Test
    void staticfactory(){
        Order.primeOrder(new Product());
    }


}