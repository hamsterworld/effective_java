package effective.java.item39.markerannotation.practice;

import effective.java.item39.markerannotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) {
        int tests= 0;
        int passed = 0;
        Class<RunTests> runTestsClass = RunTests.class;
        Method[] declaredMethods =
                runTestsClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            tests++;
            try{
                m.invoke(null);
                passed++;
            } catch (InvocationTargetException e){
                Throwable cause = e.getCause();
                System.out.println(m + " 실패 : " + cause);
            } catch (Exception e){
                System.out.println(" 잘못 사용한 @Test: " + m);
            }
        }
    }
}
