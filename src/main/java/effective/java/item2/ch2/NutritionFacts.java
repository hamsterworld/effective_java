package effective.java.item2.ch2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class NutritionFacts {

    private final int servingSize;  //필수
    private final int servings;     //필수
    private final int calories;     //선택
    private final int fact;         //선택
    private final int sodium;       //선택
    private final int carbohydrate; //선택

    /** 빌더를 사용해야될때?
     *
     *  1.필수적인 필드와 선택적인 필드가있을때 이것때메 생성자가 너무많아질때.
     *  2.불변필드를 만들고싶다.
     *
     *  lombok 을 사용하면 편하다 @bulider
     *  단점?
     *  Annotation Processor 를 꼭알자.
     *
     *  1.단점 allArg 를 생성하기때문에 이게싫다면 private 설정을 하자
     *  2.필수값을 지정해줄수 없다.
     *  그래서 우리가정말 필수값을 생성자로 받고 사용하고싶다면
     *  원래 빌더코드를 사용해야한다.
     */



}
