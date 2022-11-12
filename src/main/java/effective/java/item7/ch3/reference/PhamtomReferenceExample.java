package effective.java.item7.ch3.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Object가
 * 이제 더이상 strong한 reference가 없고
 * soft reference만 남았을때 gc를 해준다
 * 언제? 메모리가 부족하다고 판단될때.
 * 무조건 수거해 가지않는다.
 */
public class PhamtomReferenceExample {

    public static void main(String[] args) throws InterruptedException{
        BigObject strong = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();
        /**
         * 얘를 해준이유는 무슨 커스텀한 매서드를 사용하기위함이라던데
         * ex) cleanUp매서드같은거.
         * 별거아닌듯
         */
        BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);
        //phantom ref는 queue가 필요하다.
        //그래서 phantom은 strong이 사라지면 gc가되서정리는되는데 referencequeue에다가넣어놓는다.
        //그래서 나중에 꺼내서 쓸수가잇다.
        //1.phantom을 써서 resource를 반납할수있다.
        //2.언제 이 커다란 객체가 사라졋음을 알수있을때. 그때 빈 메모리를 잠시 사용하는것이다.
        //ex)정말 메모리에 민감한 어플의 경우가 그렇다.사실이런경우 거이없긴하다
        //그래서 아 이때사라지니까 그때 다른걸사용하자 이런용도이다.

//        PhantomReference<BigObject> phantom = new PhantomReference<>(strong,rq);

        strong = null;

        System.gc();
        Thread.sleep(3000L);

        //pantom은 살아있다.. 큐에...
        System.out.println(phantom.isEnqueued());

        Reference<? extends BigObject> re = rq.poll();
        BigObjectReference bigObjectReference = (BigObjectReference) re;
        bigObjectReference.cleanUp();
        re.clear();
    }
}
