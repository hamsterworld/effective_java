package effective.java.item5.ch2;


public class DictionaryFactory{
    public static Dictionary get() {
        DefaultDictionary defaultDictionary = new DefaultDictionary();
        return defaultDictionary;
    }

//    public static Dictionary get() {
//        return null;
//    }
}
