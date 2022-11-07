package effective.java.item5.ch2;

public class SpellCheckerTest {

    //Supplier는 완벽한 factory의 대체제이다.
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
        spellChecker.isValid("test");
        SpellChecker spellChecker1 = new SpellChecker(MockDictionary::new);
        spellChecker1.isValid("test1");
    }

}
