package effective.java.item16.ch2;

import java.awt.*;

public class DimensionExample {

    public static void main(String[] args) {
        Button button = new Button("hello button");
        button.setBounds(0,0,20,10);

        Dimension size = button.getSize();
        // Dimension 은 내부 field 를 바깥으로 노출하고있다.
        // 이게문제다.
        // 물론 한두개 카피는 문제는 안되지만 수백만개를 카피하게되면 문제가생긴다.
        // 아래 doSomething 을 봤을때
        // dimension 으로 뭘하려고하면 안에 필드가 노출되있으므로 언제든 변경될수있다.
        // 그러면 우리는 그값이 변하지않게 다룰려면 결국에는 복사해서 써야된다.
        // 이런짓을 수백만번 반복하게되면 성능저하
        // 하지만 이것보다 결국 저렇게 복사해서 쓰는게 더불편하다.(강사의 생각)
        System.out.println(size.height);
        System.out.println(size.width);

        doSomething(size);
    }

    private static void doSomething(Dimension dimension) {
        Dimension dimension1 = new Dimension();
        int width = dimension1.width;
        int height = dimension1.height;
    }
}
