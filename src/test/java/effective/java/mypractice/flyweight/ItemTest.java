package effective.java.mypractice.flyweight;

import org.junit.jupiter.api.Test;


class ItemTest {

    @Test
    void item(){

        Item 햄스터 = ItemFactory.factory("햄스터");
        Item 햄스터1 = ItemFactory.factory("햄스터");

    }

}