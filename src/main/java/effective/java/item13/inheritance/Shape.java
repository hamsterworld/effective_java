package effective.java.item13.inheritance;

/**
 * p84, p126 일반적으로 상속용 클래스(추상클래스,인터페이스)에 Cloneable 인터페이스 사용을 권장하지 않는다.
 * cloneable 을 구현하는 순간 이 클래스를 확장하려는 프로그래머에게 많은 부담을 주기 때문이다.
 * 아래는 굳이 사용한 경우이다.
 */
public abstract class Shape implements Cloneable {

    private int area;

    public abstract int getArea();


    /**
     * p84,
     * 부담을 덜기 위해서는 기본 clone() 구현체를 제공하여,
     * cloneable 구현 여부를 서브 클래스가 선택할 수 있다.
     * 그래서 하위는 굳이 재정의할필요가없어진다.
     * 그러나 원한다면 다시 재정의 할수도있다.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * p85, Cloneable 구현을 막을 수도 있다.
     */
//    @Override
//    protected final Object clone() throws CloneNotSupportedException {
//        throw new CloneNotSupportedException();
//    }
}
