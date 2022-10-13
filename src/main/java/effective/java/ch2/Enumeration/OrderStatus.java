package effective.java.ch2.Enumeration;

/**
 * OrderStatus를 이렇게 아래처럼 4가지 열거형으로 정했다면
 * Orderstatus는 앞으로 4가지 상태값밖에 가지지못한다.
 * Order class를 가서한번 보면 더 이해가 쉽다.
 * 즉,열거형을 쓰게되면 특정한 값들로만 '제한'할수있다는게 장점이다.
 * type-safe라고도 표현한다.
 * 또 밑에 4가지는 오로지 인스턴스가 딱1개만 만들어진다.
 * 그래서 싱글톤패턴을 안전하게 구현하는것중하나가 열거형을 사용하는것이다.
 *
 *
 */
public enum OrderStatus {

    PREPARING(0),SHIPPED(1),DELIVERING(2),DELIVERED(3);

    private int number;

    OrderStatus(int number){
        this.number = number;
    }

}
