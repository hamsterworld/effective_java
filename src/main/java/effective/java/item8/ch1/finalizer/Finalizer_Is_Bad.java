package effective.java.item8.ch1.finalizer;

/**
 * finalize 와 cleaner 는 사용하지마라.
 */
public class Finalizer_Is_Bad {

    @Override
    protected void finalize() throws Throwable{
        System.out.print("");
    }

}
