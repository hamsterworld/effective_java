package effective.java.item5.ch2;

public class DefaultDictionary implements Dictionary {
    @Override
    public void contains(String test) {
        System.out.println(test);
    }
}
