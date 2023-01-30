package effective.java.item2.ch3;

import effective.java.item2.ch2.NutritionFacts1;
import lombok.experimental.SuperBuilder;

import java.util.Comparator;
import java.util.Objects;

/**
 * inner class 와 outer class 의 차이를 좀 알아야겟다.. 생성자나 이런거 등등
 */
public class NyPizza extends Pizza{
    public enum Size{ SMALL,MEDiUM,LARGE }
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder>{

        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build(){
            return new NyPizza(this);
        }

        @Override
        protected Builder self(){
            return this;
        }

    }


    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }




}
