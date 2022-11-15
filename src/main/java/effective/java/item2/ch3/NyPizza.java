package effective.java.item2.ch3;

import java.util.Comparator;
import java.util.Objects;

/**
 * inner class와 outer class의 차이를 좀 알아야겟다.. 생성자나 이런거 등등
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

    public static class Builder2 extends Pizza.Builder<Builder2>{

        private final Size size;

//        public <R> test2(Comparator<? extends R> s){
//            return s.compare((o1, o2) ->  o1 - o2);
//        }

        public Builder2(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build(){
            return new NyPizza(this);
        }

        @Override
        protected Builder2 self(){
            return this;
        }

    }

    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }

    private NyPizza(Builder2 builder){
        super(builder);
        size = builder.size;
    }

    private void test2(){

    }

}
