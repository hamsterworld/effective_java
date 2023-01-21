package effective.java.item1.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflection {

    /**
     *  class 정보는 JVM 에있는 클래스로더가 읽어드린다.
     *  그리고 해당하는 정보를 메모리 어딘가에 둔다.
     *  이정보를 통해서 많은것을 할수가있다.
     *  그래서 리플랙션을 사용해서 클래스정보를 이용해
     *  인스턴스제작,필드값변경,메소드실행등등이 가능하다.
     *
     *  언제사용?
     *  class 에 붙어잇는 annotation 정보도 읽어올수있다.
     *  @Configuratiom , @Bean 등등..
     *  그래서 특정한 어노테이션이 붙어있는 class 인가?
     *  만약 @Bean 이 붙어잇으면 아이것을 이매서드를
     *  읽어서 내부적으로 가지고있자등등
     */

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("effective.java.item1.reflection.ClassLoaderTest");
        //생성자 소환
        Constructor<?> constructor = aClass.getConstructor();
        ClassLoaderTest o = (ClassLoaderTest)constructor.newInstance();
        o.test();

        //그러나 내가 매서드조차 모를때
        Annotation[] annotations = aClass.getAnnotations();
        Method declaredMethod = aClass.getDeclaredMethod("test");
        System.out.println(declaredMethod.getName());

    }

}
