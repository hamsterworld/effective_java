package effective.java.item6.ch3;

public class Deprecation {

    // TODO 애노테이션 프로세서
    // 항상기억하자 애노테이션은 거이주석과 흡사하다는 사실을!
    // 그래서 애노테이션 프로세서를 통해서 컴파일 경고메시지를 알려준다.

    /**
     * @Deprecated in favor of
     * {@link #Deprecation(String)}
     */                                          //왼쪽처럼 주석을 남겨서 사용자제를 부탁한다. 그리고 대안도 작성.
//    @Deprecated(forRemoval = true,since = "1.2") //자바9부터 추가된 빨간색,버전기능
    public Deprecation(){

    }

    private String name;

    public Deprecation(String name){
        this.name = name;
    }

}
