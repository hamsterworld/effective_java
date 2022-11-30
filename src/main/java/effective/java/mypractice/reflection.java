package effective.java.mypractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class reflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("effective.java.mypractice.Order");
        Constructor<?> constructor = aClass.getConstructor();
        Order o = (Order)constructor.newInstance();
    }

}
