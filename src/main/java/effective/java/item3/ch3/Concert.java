package effective.java.item3.ch3;


import java.util.function.Supplier;

public class Concert {

    public void start(Supplier<Singer> singerSupplier){
        Singer singer = singerSupplier.get();
        singer.sing();
    }

    //Supplier를 만족하면 사용할수있다.

    public static void main(String[] args) {
        Concert concert = new Concert();
        concert.start(Elvis::getInstance);
        concert.start(() -> Elvis.getInstance());

        concert.start(MetaElvis::getInstance);
    }

}
