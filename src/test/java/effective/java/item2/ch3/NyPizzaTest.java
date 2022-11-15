package effective.java.item2.ch3;

import org.junit.jupiter.api.Test;

import java.util.Set;


class NyPizzaTest {

    @Test
    void test(){

        NyPizza Nypizza1 = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        NyPizza Nypizza2 = new NyPizza.Builder2(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        System.out.println(Nypizza1);

        Set<Pizza.Topping> toppings = Nypizza1.toppings;
    }

    @Test
    void test2(){

        new NyPizza.Builder(NyPizza.Size.LARGE).test(new NyPizza.Builder(NyPizza.Size.LARGE));
        new NyPizza.Builder2(NyPizza.Size.LARGE).test(new NyPizza.Builder2(NyPizza.Size.LARGE));


    }

}