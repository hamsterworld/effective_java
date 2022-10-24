package effective.java.item3.ch2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElvisReflection {

    public static void main(String[] args) {
        try {

            Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
            //참고로 getDeclaredConstructor는 선언되어잇는 생성자도 접근가능하다.
            //getConstructor는 public Constructor한 애들만 접근가능하다. 그래서 private한 생성자도 접근가능하다.
            declaredConstructor.setAccessible(true);
            //또 true를 주지않으면 private생성자를 호출할수없게된다.
            Elvis elvis1 = declaredConstructor.newInstance();
            Elvis elvis2 = declaredConstructor.newInstance();
            System.out.println(elvis1 == elvis2);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
