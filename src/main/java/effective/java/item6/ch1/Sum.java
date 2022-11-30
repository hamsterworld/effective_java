package effective.java.item6.ch1;

public class Sum {
    private static long sum(){
        Long sum = 0L;
        for (long i = 0; i <=Integer.MAX_VALUE; i++){
            // 기본타입을 래퍼타입으로 변경할때
            // auto boxing 이 자동으로 일어난다.
            // 반대로 래퍼타입에서 기본타입으로 변경될때
            // unboxing 이 일어난다.
            // 불필요하게 auto boxing 이일어난다면? 아래처럼
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        long x = sum();
        long end = System.nanoTime();

        System.out.println((end - start) / 1_000_000. + " ms.");
        System.out.println(x);

        while(true);
    }

    /**
     * 여기서는 이런 3가지 상황에대해서 조심하라고한거지
     * 객체를 아예 만들지말라는것이아니다. 라는점을 주의할것.
     */

    /**
     * 1. 사용자제 API Deprecation -> 플랫폼을 개발하다보면 API 가 변경될때가 있다.
     * 2. 정규표현식이 무거운 리소스라는것을 알았으니 이것을 언제쓰는지? -> 나중에 필요하면 찾아쓰자
     * 3. GC 컬렉션을 혹시 나중에 공부할때가되면 어떤순서로 공부해야하는지 가이드도 잡아주겟다.
     * 4. Lazy-Loading -> 인스턴스가 사용될때 만들어서 쓰자. (득을 보는경우가 많지는 않다.)
     * 즉, 로딩올릴때 올릴거냐 아니면 서비스를 운영하면서 올릴거냐? 조삼모사긴하다.
     * 오히려 static 때 올리는게 더 나을수도있다.
     * 5. 방어적복사 -> 기존객체랑 비슷하게만들지말고 최대한 새로운객체를 만들어라.
     */

}
