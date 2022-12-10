package effective.java.item8.ch1.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;

public class CleanerIsNotGood {

    public static void main(String[] args) throws InterruptedException {

        Cleaner cleaner = Cleaner.create();

        ArrayList<Object> list = new ArrayList<>();
        BigObject bigObject = new BigObject(list);

        //오른쪽에 들어오는 runnable 을 이용해서 GC 할때 정리 작업을해라.
        cleaner.register(bigObject,new BigObject.ResourceCleaner(list));

        //gc의 대상이 된다.
        bigObject=null;
        System.gc();
        Thread.sleep(3000L);

        //그러나 권장하는 방법은 이게아니다. AutoCleaner 이다.
    }
}
