package effective.java.item3.ch3;


import java.util.function.Supplier;

public class Concert {

    public void start(Supplier<Singer> singerSupplier){
        Singer singer = singerSupplier.get();
        singer.sing();
    }

    // Supplier 를 만족하면 사용할수있다.
    // 사실 이게 크리티컬한 장점이라고는 생각하지않는다.
    // 일단은, 생성자였다면 절대 제공할수없엇던 기능이긴하다.

    public static void main(String[] args) {
        Concert concert = new Concert();
        concert.start(Elvis::getInstance);
        concert.start(() -> Elvis.getInstance());

        concert.start(MetaElvis::getInstance);
    }

}
