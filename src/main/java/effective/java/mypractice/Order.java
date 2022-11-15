package effective.java.mypractice;

import effective.java.item1.staticfactory.GoodPoint1.Product;

public class Order {

    private boolean prime;
    private boolean urgent;
    private Product product;

    public static Order primeOrder(Product product){
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product){
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

}
