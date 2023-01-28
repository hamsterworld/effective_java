package effective.java.item19;

import java.time.Instant;

public class Sub extends Super{
    private final Instant instant;

    Sub(){
        // 상속받은 class 는 생성자에서 super() 를 호출하고있다.
        // 그래서 먼저 overrideMe()를 호출하고있다.
        // 근데 instance 는 안만들어졌다.
        // 그래서 null 이발생
        // 그래서 그다음은 잘된다.

        // 같은맥락으로 cloneable 과 serializable 을 구현할때도 조심해야한다.
        // 둘다 instance 를 만드는 interface 들이다.
        // 즉, 생성자를 호출하는것과 비슷한 효과가 있다.
        // clone,readObject 과같은 이런 매서드안에서
        // 마찬가지로 재정의해서 쓰는 method 를 사용하면 안된다.
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
