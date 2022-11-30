package effective.java.item8.ch1.cleaner;

import java.util.ArrayList;
import java.util.List;

/**
 * cleaner 는 어떻게 쓸까요?
 * Runnable 을 상속해서 여기서 작업을 한다.
 * finalze 작업을 여기서한다고생각하면된다.
 * 그리고 Cleaner class 에서 자기객체를 참조하면안된다.(절대로 BigObject 를 참조하면 안된다,)
 * 결국 저 class 가 하는게 객체를 없애주려고하는건데 참조하거나그러면 부활할수있기때문이다.
 */
public class BigObject {

    private List<Object> resource;

    public BigObject(ArrayList<Object> list) {
        this.resource = list;
    }

    public static class ResourceCleaner implements Runnable{

        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean){
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up.");
        }
    }

}
