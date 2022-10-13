package effective.java.ch2.staticfactory.GoodPoint345;

public class KoreanHelloService extends HelloService implements HelloServiceInterface{
    @Override
    public String hello() {
        return "안녕";
    }
}
