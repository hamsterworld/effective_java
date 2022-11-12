package effective.java.item8.ch1.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        int i =0;
        while(true){
            i++;
            new FinalizerIsBad();

            //위처럼 gc의 대상이되면 finalze method를 실행해준다.
            //근데 이 method 실행자체가 queue에 들어간다.
            //그래서 Finalizer에 reference queue가 있다.
            //그래서 그것이 얼마나 쌓아엿는지 클래스로더로 본다는 것.
            //안에 보면 gc가 안되고 쌓인것을 볼수가 있다.
            //queue를 처리하는 우선순위가 낮기때문에 아직 삭제가 안된것. --> 이래서 권장하지않는다.
            if((i % 1_000_000) == 0){
                Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
                Field queueStaticField = finalizerClass.getDeclaredField("queue");
                queueStaticField.setAccessible(true);
                ReferenceQueue referenceQueue = (ReferenceQueue) queueStaticField.get(null);

                Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
                queueLengthField.setAccessible(true);
                long o = (long)queueLengthField.get(referenceQueue);
                System.out.println("there are " + o);
            }
        }
    }
}
