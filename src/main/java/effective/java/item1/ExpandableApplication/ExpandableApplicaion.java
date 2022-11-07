package effective.java.item1.ExpandableApplication;

public class ExpandableApplicaion {

    /**
     *  확장가능하다는것(expandable)은
     *  코드를 변경하지않고
     *  외적인 요소를 변경했을때
     *  그 application의 동작을 다르게
     *  동작하게 만들수있는가.
     */

    /**
     * spring di를 이용해 확장가능한 application을 만들어보자
     *
     * 서비스구현체들이 다양한형태로 구현될수있는
     * 서비스를 제공하여 확장가능한 application을
     * 가능하게한다면 그interface를 서비스제공자인터페이스라고한다.
     *
     */


    /**
     *  서비스제공등록 api = 서비스등록api를 제공하는애들
     *  ex)@Configuration을 통해
     *  bean을 등록하는애들
     *  ex)META-INF가 여기서는 서비스를 등록하는 api라고도할수있다.
     *
     *  서비스접근 api = 서비스접근 api
     *  ApplcationContext applicationcontext = new AnnotationConfigApplicationContext(Appconfig.class)
     *  @Autowired도 있고, private final로 접근하는 방법도 있다.
     *
     *
     *  브릿지패턴
     *  구체적인것과 추상적인것을 분리한다.
     *  이2개가 서로 독립적으로 발전할수있게끔한다.
     *  서로 영향을 주지않으면서 개별적인 계층구조로 발전할수있게한다.
     *
     */
}
