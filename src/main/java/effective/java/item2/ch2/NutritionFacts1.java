package effective.java.item2.ch2;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@ToString
public class NutritionFacts1 {

    private final int servingSize;  //필수
    private final int servings;     //필수
    private final int calories;     //선택
    private final int fact;         //선택
    private final int sodium;       //선택
    private final int carbohydrate; //선택

    public static class Builder{
        private final int servingSize;  //필수
        private final int servings;     //필수
        private int calories = 0;     //선택
        private int fact = 0;         //선택
        private int sodium = 0;       //선택
        private int carbohydrate = 0; //선택

        //Validation 이 필요하다 원시타입으로 받으므로.
        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
            validateServing(servingSize,servings);
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder fact(int fact){
            this.fact = fact;
            return this;
        }

        public Builder sodium(int sodium){
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts1 bulide(){
            return new NutritionFacts1(this);
        }

        private void validateServing(int servingSize,int servings){
            if(servingSize < 0 || servings < 0){
                throw new IllegalArgumentException("servingSize, servings 는 음수가 될수 없습니다.");
            }
        }

    }

    private NutritionFacts1 (Builder builder){

        ArrayList<NutritionFacts> list = new ArrayList<>();

        list.add(new NutritionFacts(10,101,10,10,10,10));
        list.add(new NutritionFacts(10,101,10,10,10,10));
        list.add(new NutritionFacts(10,101,10,10,10,10));
        list.add(new NutritionFacts(10,101,10,10,10,10));

        Collections.sort(list,(o1, o2) -> o1.getFact() - o1.getFact());

        Comparator<NutritionFacts> compare = (o1, o2) -> o1.getFact() - o1.getFact();

        Comparator<NutritionFacts> compare1 = new Comparator<NutritionFacts>() {
            @Override
            public int compare(NutritionFacts o1, NutritionFacts o2) {
                return 0;
            }
        };

        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.fact = builder.fact;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
        this.calories = builder.calories;

    }

    public static void main(String[] args) {
        NutritionFacts1 bulide1 = new Builder(1, 1).calories(1).sodium(1).bulide();

    }



}
