package effective.java.item20.ch2;

public abstract class AbstractCat {

    protected abstract String sound();

    protected abstract String name();

    protected String hamster(){
        return "hi";
    }

    static protected String hamster1(){
        return "hi1";
    }

}
