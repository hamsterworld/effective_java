package effective.java.item60;

/**
 * 정수타입을 사용한 올바른 해결법 1
 */
public class IntChange {
    // 코드 60-3 정수 타입을 사용한 해법 (357쪽)
    public static void main(String[] args) {
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(센트): " + funds);
    }
}
