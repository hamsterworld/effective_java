package effective.java.item45;

@FunctionalInterface
public interface TestFunction<T> {

    T hamster(T t);

    static TestFunction1 identity1(){
        return t-> t;
    }
}
