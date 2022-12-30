package effective.java.item5.ch2;


public class DictionaryFactory{
    public static Dictionary get() {
        DefaultDictionary defaultDictionary = new DefaultDictionary();
        // defaultDictionary 를 막 만드는데 여러가지 로직이 필요할수있다..
        return defaultDictionary;
    }

//    public static Dictionary get() {
//        return null;
//    }
}
