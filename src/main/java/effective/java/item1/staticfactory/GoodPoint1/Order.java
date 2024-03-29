package effective.java.item1.staticfactory.GoodPoint1;

/**
 * 1. 이름을 가질 수 있다.
 */
public class Order {

    private boolean prime;
    private boolean urgent;
    private Product product;

//    public Order(Product product,boolean prime){
//        this.product = product;
//        this.prime = prime;
//    }

//    public static void main(String[] args) {
//        new Order(new Product(),true); // 일반주문
//        //긴급주문
//    }

//    public Order(Product product,boolean urgent){
//        this.product = product;
//        this.urgent = urgent;
//    }


    // 같은 파라미터 개수는 오버로딩
//    public Order(boolean urgent,Product product){
//        this.product = product;
//        this.urgent = urgent;
//    }


    /**
     *  위에와 같이 표현하고싶다.
     *  위에꺼는 일반 주문
     *  밑에꺼는 긴급 주문
     *  하지만 자바의 오버로딩은 변수타입까지만 보기때문에
     *  위에 2개의 생성자는 하나의 class 에서는 생성될수가없다.
     *  세번째처럼은 되지만 저것은 고려대상이 아니다.
     *  그러면 어떻게?!
     *  그래서 책에서는 정적팩토리매서드로 표현하자라고 되어있다.
     */
    public static Order primeOrder(Product product){
        //자기자신의 instance 를 static 으로서 사용해버리넴!?
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product){
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {
        Order order = Order.primeOrder(new Product());
        Order order1 = Order.urgentOrder(new Product());
    }

    /**
     *  위에처럼 정적 팩토리 매서드를 사용해서 처리하라고 권장하고있다.
     *  그러면 이렇게 만들어주는 객체의특징을 primeOrder,urgentOrder 과같이
     *  팩토리매서드의 이름으로 더 잘 표현할수있다.
     *  이것이바로 첫번째 장점.
     * */
    

}
