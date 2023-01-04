package effective.java.item39.markerannotation;

// 코드 39-2 마커 애너테이션을 사용한 프로그램 예 (239쪽)
public class Sample {
    @Test
    public static void m1() { }        // 성공해야 한다.
    public static void m2() { }
    @Test public static void m3() {    // 실패해야 한다.
        throw new RuntimeException("실패");
    }
    public static void m4() { }  // 테스트가 아니다.
    @Test public void m5() { }   // 잘못 사용한 예: 정적 메서드가 아니다.
    public static void m6() { }
    @Test public static void m7() {    // 실패해야 한다.
        throw new RuntimeException("실패");
    }
    public static void m8() { }
}

// 사실상 어노테이션은 Sample Class 에 아무런 영향을 주지 않는다.
// 그저 어노테이션이 관심있는 프로그램에게 추가적인 정보를 준것이다.
// 다시이야기하면 어노테이션이 달려있는 놈에게 이 어노테이션이 달려있는것에 관심있는 애가
// 특별한 처리를 할수있는 기회를 준다는 것이다.

// 어노테이션 processing 에대해서 알아보자.
