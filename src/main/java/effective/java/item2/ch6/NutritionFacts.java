package effective.java.item2.ch6;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutritionFacts implements Serializable {

    private int servingSize;  //필수
    private int servings;     //필수
    private int calories;     //선택
    private int fact;         //선택
    private int sodium;       //선택
    private int carbohydrate; //선택
    private boolean healthy;

    public NutritionFacts(){

    };

    /**
     *
     *  그렇다면 boolean은 어떻게해야
     *  자바빈 규약에 맞는 getter,setter를 만들수있을까?
     *  boolean만 특별하게
     *  isHealthy로 만들어준다.
     *
     *  이것이 자바빈즈 규약이다.
     *  이렇게 만들어야 다른라이브러리에서도 이것을쓸때
     *  자바빈즈규약에 맞게 사용할수있다.
     *
     *  결론 getter,setter이런 규약들(자바빈즈)이 있어야
     *  다른툴에서나 라이브러리에서도 규약에따라
     *  값에 접근하거나 수정하는데 사용될수있다.
     *
     *  자바빈즈에
     *  왜 아무것도없는 기본생성자가 잇어야할까?
     *  (꼭 필수는아니다.)
     *  자바빈즈는 왜이것을 권장할까?
     *  인스턴스를만들기편하기때문이다.
     *
     *  Serializable를 구현하라고 되어있다.
     *  직렬화를해서 데이터를 보관해놧다가
     *  다시 데이터를 꺼내쓸수있기대문이다.(역직렬화)
     *  직렬화에대해서 조금만더 찾아볼것
     *
     *  json변환,model담기,jpa등등
     *  객체들의 필드에 접근하는 일반적인 방법이 필요하다
     *  그래서 getter,setter같은 자바빈즈규약을 준수해야한다.
     *
     */


}
