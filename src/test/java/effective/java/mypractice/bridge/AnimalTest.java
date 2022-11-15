package effective.java.mypractice.bridge;

import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void hunting(){

        Animal bird = new Bird(new Hunting_Method1());
        bird.hunt();

    }

}