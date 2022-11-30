package effective.java.item5.ch2;

public class MockDictionaryFactory{

    public static Dictionary get() {
        MockDictionary mockDictionary = new MockDictionary();
        return mockDictionary;
    }

}
