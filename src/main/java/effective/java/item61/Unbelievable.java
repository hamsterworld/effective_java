package effective.java.item61;

// 코드 61-3 기이하게 동작하는 프로그램 - 결과를 맞혀보자! (360쪽)
public class Unbelievable {
    /**
     * 기본타입과 박싱타입을 혼용하는 연산에서는
     * 기본적으로 모두 박싱이 풀리게된다.
     * 박싱이 풀리고 박싱 value 가 null 이라면 NPE 를 터트리게된다.
     * 해결법은 간단하긴하다 i 의 type 을 int 로 변경시켜주면된다.
     */
    static Integer i;
    public static void main(String[] args) {
        if (i == 42)
            System.out.println("믿을 수 없군!");

        Long sum = 0L;
        for(long i = 0L; i<Long.MIN_VALUE; i++){
            sum += i;
        }
        // 위 코드는 끔찍히 느리다.
    }
}
