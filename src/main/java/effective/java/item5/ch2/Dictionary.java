package effective.java.item5.ch2;

public interface Dictionary {

    void contains(String test);
    static Dictionary of(String lang){
        if(lang.equals("default")){
            return new DefaultDictionary();
        } else {
            return new MockDictionary();
        }
    }

}
