package effective.java.item8.ch1.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        int i =0;
        while(true){
            i++;

            // 아래 finalizer 는 참조를 안하고 객체만 만들고 끝나니까
            // GC의 대상이 된다.
            // 그리고 아래의 코드처럼 100만개 만들때마다 finalizer 를 소환하게된다.
            new Finalizer_Is_Bad();

            // 위처럼 GC의 대상이 되면 finalize method 를 실행해준다.
            // 근데 이 method 실행자체가 queue 에 들어간다.
            // 그래서 Finalizer 에 reference queue 가 있다.
            // 그래서 그것이 얼마나 쌓아엿는지 클래스로더로 본다는 것.
            // 안에 보면 gc가 안되고 쌓인것을 볼수가 있다.
            // Finalizer 의 queue 를 처리하는 쓰레드의 우선순위가 낮기때문에 아직 삭제가 안된것. --> 이래서 권장하지않는다.
            
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
