package effective.java.item60;

/**
 * 어설픈 코드들
 * => 금융 계산에는 BigDecimal,int,long 을 사용해야한다.
 */
public class Change {
    // 코드 60-1 오류 발생! 금융 계산에 부동소수 타입을 사용했다. (356쪽)
    // float 과 double 은 부동소수 타입을 사용하여 근사치를 계산하도록 설계되었다.
    // 따라서, 정확한 결과가 필요할때는 맞지않는다.
    public static void main(String[] args) {

        System.out.println(1.03 - 0.42);
        System.out.println("=========");

        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds);
    }
}
