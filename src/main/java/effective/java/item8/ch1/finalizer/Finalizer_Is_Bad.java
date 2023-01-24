package effective.java.item8.ch1.finalizer;

/**
 * finalize 를 사용 하는 방법.
 */
public class Finalizer_Is_Bad {

    @Override
    protected void finalize() throws Throwable{
        System.out.print("");
    }

}
