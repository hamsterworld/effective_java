package effective.java.mypractice;

import effective.java.item1.staticfactory.GoodPoint1.Product;

import java.util.function.Supplier;

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

    //결국 이런 Supplier 대신 원래 factory 가들어가서 product 를 대신생산해줄수있다.
    //마약에 product 를 생산하는게 매우 무겁다면.
    //그러나 이렇게 supplier 가 대신 대체해줄수도 있다는 것이다.
    public static Order SupplierOrder(Supplier<Product> supplier){
        Order order = new Order();
        order.prime = true;
        order.product = supplier.get();
        return order;
    }

    public static Order SupplierOrder2(Supplier<Order> supplier){
        Order order = supplier.get();
        supplier.get().prime = true;
        supplier.get().product = new Product();
        return  order;
    }

    public static Order urgentOrder(Product product){
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    private Order(){

    }

    private static final Order order = new Order();

    public static Order getInstance(){
        return order;
    }

}
