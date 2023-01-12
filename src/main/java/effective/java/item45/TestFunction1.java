package effective.java.item45;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface TestFunction1<T> extends TestFunction<T>{

    @NotNull
    static TestFunction1 identity(){
        return t-> t;
    }

}
