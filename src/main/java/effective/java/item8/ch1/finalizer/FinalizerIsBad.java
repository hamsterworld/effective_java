package effective.java.item8.ch1.finalizer;

/**
 * finalize와 cleaner는 사용하지마라.
 */
public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable{
        System.out.print("");
    }

}
