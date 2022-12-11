package effective.java.item20.ch2;

// 여기서 MyCat 은 더이상 AbstractFlyable 상속을 못받는다.
// interface 와 추상클래스로 가능
// 이것이 책에서 말하는 다중상속을 시뮬레이트 할수있다는말이다.
public class MyCat extends AbstractCat implements Flyable{

    private MyFlyable myFlyable = new MyFlyable();

    @Override
    protected String sound() {
        return "인싸 고양이 두 마리가 나가신다!";
    }

    @Override
    protected String name() {
        return "유미";
    }

    public static void main(String[] args) {
        MyCat myCat = new MyCat();
        System.out.println(myCat.sound());
        System.out.println(myCat.name());
    }

    @Override
    public void fly() {
        this.myFlyable.fly();
    }

    private static class MyFlyable extends AbstractFlyable{
        @Override
        public void fly() {
            System.out.println("날아라");
        }
    }
}
