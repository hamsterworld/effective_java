package effective.java.item3.ch4;

import effective.java.item3.ch1.IElvis;

public enum Elviss implements IElvis {

    INSTANCE;

    public void leaveTheBuilding(){
        System.out.println("지금 갈게");
    }

    @Override
    public void sing() {
        System.out.println("랄랄라라~");
    }

    /**
     *  이방법으로하면 리플렉션과 직렬화역직렬화에 안전하다.
     *  enum을 통해 리플렉션에서 생성자호출이 막혀있다.
     *  Elviss.class를 보면 생성자가 있긴하다.
     *  enum은 열거형이기때문에 절대로 new로 만들수가없다.
     *  그래서 리플렉션에서도 방지되어있다.
     *  enum은 또 역직렬화직렬화에도 안전하다 readResolve해도되지않아도된다.
     *
     *  test는 어떻게할수있을까?
     *  enum은 interface가 구현이 가능하다.
     *  그래서 interface를 도입해서 사용하자.
     *  그리고 client code가 interface코드를 사용하도록한다.
     *  test시에는 interface의 별도의 구현체를 넘겨주도록한다.
     */

    public static void main(String[] args) {
        Elviss elvis = Elviss.INSTANCE;
        elvis.leaveTheBuilding();
    }

}
