package effective.java.item20.ch2;

public abstract class AbstractFlyable implements Flyable{
    @Override
    public void fly() {
        System.out.println("너랑 딱 붙어있을게!");
    }
}
