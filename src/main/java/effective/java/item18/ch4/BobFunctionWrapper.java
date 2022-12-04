package effective.java.item18.ch4;

public class BobFunctionWrapper implements FunctionToCall{

    private final BobFunction bobFunction;

    public BobFunctionWrapper(BobFunction bobFunction) {
        this.bobFunction = bobFunction;
    }

    @Override
    public void call() {
        this.bobFunction.call();
        System.out.println("커피마실래?");
    }

    @Override
    public void run() {
        this.bobFunction.run();
    }
}
