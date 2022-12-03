package effective.java.item17.ch4;

public class WhiteShip {

    private int x;
    private int y;

    public WhiteShip() {
        this.x = 1;
        this.y = 2;
    }

    public static void main(String[] args) {

        // 아래코드는 어떤순서를 가지고 할당이 되고 실행이 될까?
        // Object w = new WhiteShip
        // w.x = 1
        // w.y = 2
        // whiteShip = w
        // 만약에 프로그램이 메모리모델이 허용하는 내에서 순서가 변경될수있다.
        // 저거 위에 순서대로 실행되도록 하는것은 구현체가 아니다.
        // 어떤 경우에는 이렇게될수도 있다.
        // Object w = new WhiteShip
        // whiteShip = w
        // w.x = 1
        // w.y = 2
        // 메모리모델은
        // 하나의 thread 내에서만 유효한지않은지만 결정한다.
        // 위 방법도 유효하다.

        // 멀티쓰레드가 섞인다면? WhiteShip 이라는 인스턴스를
        // 여러 쓰레드가 사용한다면?
        // 즉 2번째 실행순서로 된다면
        // 다른 쓰레드는 w 를 가지고 x ,y 0 으로 할당된 상태에서 사용할수있는것이다.
        // 이것이바로 불완전한 초기화가 발생할 수 있다 (멀티쓰레딩 환경에서)
        // 근데 실제로 final 을 사용하지않아서 발생하는경우가 드물다. 물론 이론적이다.
        // 근데 final 을 사용하게된다면 final 에 값이 할당이 되야만 다른쓰레드가 사용할수있다.

        // 즉, final 을 사용하면 안전하게 초기화를 할수있다는 것이다.
        // 17.5 예제 참조
        WhiteShip whiteShip = new WhiteShip();
    }

}
