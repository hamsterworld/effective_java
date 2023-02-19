package effective.java.item69;

/**
 * 예외는 진짜 예외에서만 사용해라!
 */
public class Example {

    // 1. 코드조차 전혀 직관적이지 않다.
    // 2. 배열을 순회하는데 매우 끔찍하다
    // => 무한루프를 돌다가 배열의 끝에 도달해 Exception 을 발생시키면 그제서야 끝을낸다.
    // 절대따라하지말아야할 코드이다.
    public static void main(String[] args) {

        int[] range = new int[100];

        try{
            int i = 0;
            while(true){
                int i1 = range[i++];
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        // 정상적인 코드
        for (int i : range) {
            int i2 = i;
        }

    }

}

/**
 * 그럼 왜 저런 병신같은 짓을 했을까?
 *  - 잘못된 추론을 근거로 성능을 높이려고했다.
 *  하지만 실상은 성능이 더느리다.
 *
 *  또한 위와같은 짓은
 *  1. 코드의 직관성을 떨어뜨린다.
 *  2. 성능이 오히려 더 악화된다.
 *  3. 제대로 동작하지않을수도있다.
 *
 *  결론
 *  예외는 무조건 예외적인 상황에서만 써야하며 절대로
 *  정상적인 흐름에서 [제어]용으로 사용하면안된다 (위에 예시가 대표적이다.)
 */
