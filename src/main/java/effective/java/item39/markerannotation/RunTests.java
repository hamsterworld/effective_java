package effective.java.item39.markerannotation;

// 코드 39-3 마커 애너테이션을 처리하는 프로그램 (239-240쪽)
import effective.java.item39.repeatableannotation.ExceptionTest;

import java.lang.reflect.*;

public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("effective.java.item39.markerannotation.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause(); // Exception 을 잡아서 발생한 Cause 를 추출한다.
//                    Test annotation = m.getAnnotation(Test.class);
//                    System.out.println(annotation.value() + annotation.hamster());
                    System.out.println(m + " 실패: " + exc);
                } catch (Exception exc) {
                    System.out.println("잘못 사용한 @Test: " + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
