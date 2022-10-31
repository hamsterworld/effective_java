package effective.java.item2.ch1;

public class NutritionFacts {

    private final int servingSize; //필수
    private final int servings; //필수
    private final int calories; //선택
    private final int fact; //선택
    private final int sodium; //선택
    private final int carbohydrate; //선택

//    public NutritionFacts(int servingSize, int servings) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = 0;
//        this.fact = 0;
//        this.sodium = 0;
//        this.carbohydrate = 0;
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fact = 0;
//        this.sodium = 0;
//        this.carbohydrate = 0;
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories,int fact) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fact = fact;
//        this.sodium = 0;
//        this.carbohydrate = 0;
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories,int fact,int sodium) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fact = fact;
//        this.sodium = sodium;
//        this.carbohydrate = 0;
//    }

    //생성자 체이닝
    //코드 흐름정도만 이해

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize,servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories,int fact) {
        this(servingSize, servings, calories,fact,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories,int fact,int sodium) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fact = fact;
        this.sodium = sodium;
        this.carbohydrate = 0;
    }

    /**
     *
     *  생성자에 매개변수가 많다면 빌더를 고려하라.
     *  계층적(체이닝),자바빈즈(getter,setter)등보다는 빌더다.
     *  특히 자바빈즈는 set이 되지않은상태에서 인스턴스가 사용될수있다.
     *  ex) new Hello();
     *  hello.인사();
     *  hello.set인사("hi");
     *  이런문제.
     *
     *  자바빈즈를 사용하면 불변필드로 만들기도힘들다.
     *
     *
     */

    public static void main(String[] args) {
        new NutritionFacts(1,1);
    }



}
