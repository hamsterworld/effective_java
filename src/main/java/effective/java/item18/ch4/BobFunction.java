package effective.java.item18.ch4;

/**
 * callback = 함수인자에다가 다른 함수를 넘기는것.
 */
public class BobFunction implements FunctionToCall{

    private final Service service;

    public BobFunction(Service service) {
        this.service = service;
    }

    @Override
    public void call() {
        System.out.println("밥 먹을래?");
    }

    @Override
    public void run() {
        this.service.run(this);
    }
}
