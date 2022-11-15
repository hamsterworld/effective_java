package effective.java.item2.ch3.innerclass;

import org.junit.jupiter.api.Test;

class OuterTest {

    @Test
    void test(){
        Outer outer = new Outer();

        //Innerclass 사용
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = new Outer().new Inner();

        /**
         * static inner class는 독립적인 생성이 가능하다.
         *
         * 좀 더 얘기 해보자면, 우리가 만드는 모든 클래스들은 원래 static 메모리에 올라가는 'static'입니다.
         * 내부 클래스에 static 키워드를 붙이면,
         * 외부 인스턴스 없이 내부 클래스의 인스턴스를 바로 생성할 수 있다는 차이점이 존재 할 뿐 기능적 차이는 없습니다.
         */
//        Outer.staticInner staticInner = outer.new staticInner();
        Outer.staticInner staticInner = new Outer.staticInner("오인석");
        Outer.staticInner staticInner1 = new Outer.staticInner("오인석");

        System.out.println(staticInner1 == staticInner); // 다르다. 기본적인 class는 static이다.

        /**
         * static inner class와 inner class의 가장 큰 차이는 숨은 참조가 있다 없다.정도
         *
         * 숨은참조가 있기때문에 서로가 순환참조되서 gc의 대상이 못될수있다. -> 메모리누수의 원인이 될수있다.
         */


    }

}