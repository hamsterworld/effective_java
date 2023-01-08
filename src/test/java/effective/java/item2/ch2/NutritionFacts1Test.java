package effective.java.item2.ch2;

import org.junit.jupiter.api.Test;

class NutritionFacts1Test {

    @Test
    void NutritionFact1(){

        NutritionFacts1 carbohydrate = new NutritionFacts1.Builder(10, 10)
                .fact(5)
                .sodium(30)
                .calories(500)
                .carbohydrate(20)
                .bulide();

        System.out.println(carbohydrate);

    }

}