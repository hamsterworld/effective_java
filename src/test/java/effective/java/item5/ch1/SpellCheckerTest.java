package effective.java.item5.ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isVaile(){
        assertTrue(SpellChecker.isValid("item1to9"));
    }

    @Test
    void MockValie(){
        SpellChecker spellChecker = new SpellChecker(new Dictionary());
        spellChecker.isValid1("test1");
    }

}