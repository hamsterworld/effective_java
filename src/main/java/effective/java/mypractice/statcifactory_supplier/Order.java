package effective.java.mypractice.statcifactory_supplier;


import java.util.function.Supplier;

public class Order {

    private boolean prime;
    private boolean urgent;
    private Product product;

//    public static Order primeOrder(Product product) {
//        Order order = new Order();
//        order.product = product;
//        order.prime = true;
//        return order;
//    }
//
//    public static Order urgentOrder(Product product) {
//        Order order = new Order();
//        order.product = product;
//        order.urgent = true;
//        return order;
//    }

    //위에서처럼 원래는 이렇게 Product 를 ref로 받아야하는데

    public static Order primeOrder(Supplier<Product> supplier) {
        Order order = new Order();
        order.product = supplier.get();
        order.prime = true;
        return order;
    }

    public static Order urgentOrder(Supplier<Product> supplier) {
        Order order = new Order();
        order.product = supplier.get();
        order.urgent = true;
        return order;
    }



}
