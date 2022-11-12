package effective.java.item7.ch3.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class BigObjectReference<BigObject> extends PhantomReference<effective.java.item7.ch3.reference.BigObject> {

    public BigObjectReference(effective.java.item7.ch3.reference.BigObject strong,
                              ReferenceQueue<? super effective.java.item7.ch3.reference.BigObject> rq) {
        super(strong,rq);
    }

    public void cleanUp(){
        System.out.println("clean up");
    }

}
