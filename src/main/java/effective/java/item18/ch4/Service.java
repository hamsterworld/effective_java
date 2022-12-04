package effective.java.item18.ch4;

/**
 * callback 은 wrapper 랑 같이 쓰면 문제가 발생할수있다.
 */
public class Service {
    public void run(BobFunction bobFunction) {
        System.out.println("뭐좀 하다가");
        bobFunction.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
//        bobFunction.run();

        // this 가 bobFunction 이므로.
        // wrapper 를 통해 하지못한다.
        // 그래서 이것을 self 문제라고 한다.
        // 너무당연하긴하다.
        // 즉, callback 으로 하면 이런문제가 발생한다는것이다.
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
        bobFunctionWrapper.run();
        bobFunctionWrapper.call();
    }
}
