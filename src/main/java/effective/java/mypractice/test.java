package effective.java.mypractice;


public class test {

//    private static final Dictionary dictionary = new DefaultDictionary();
//
//    public static boolean spellcheck(String o){
//        boolean contains = dictionary.contains(o);
//        return contains;
//    }

    /**
     * 받은 자원에 따라 동작이 변경된다.
     * 그러나 여러가지 기능을 제공해주기 어렵다. -> 변경에 유연하지않음
     * 필요하다면 더많은 class 를 만들어주어야한다. 탈락
     */

    /**
     * 그렇다면 final 을 제거하고 다른사전으로 교체할수있게했다 그러나
     * 유틸클래스, singleton pattern 으로 이용한다면
     * 동시성 이슈가 발생할수있다.
     */

    /**
     * 결론적으로 외부로부터 리소스를 받아서 동작이 변경되는 클래스는
     * 유틸클래스나 singleton pattern 이 적합하지않다.
     */

    /**
     * 생성할때 생성자로부터 인스턴스를 주입받아서 final 해주는것이 제일 BEST 이다.
     */

    /**
     * 그래서 이제 외부에서 DI를 받아서 사용할수있는데,
     * 대표적으로 static factory 의 도움을받을수있다.
     * 근데 static factory 가 파라미터도 안받고 단순히 return 만해준다?
     * 그러면 이때 supplier 가 완벽한 대체제가 될수 있다는 말이다.
     */

}
