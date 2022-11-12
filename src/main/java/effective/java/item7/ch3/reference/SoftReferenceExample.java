package effective.java.item7.ch3.reference;

import java.lang.ref.SoftReference;

/**
 * Object가
 * 이제 더이상 strong한 reference가 없고
 * soft reference만 남았을때 gc를 해준다
 * 언제? 메모리가 부족하다고 판단될때.
 * 무조건 수거해 가지않는다.
 */
public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException{

        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        //밑에 코드전까지는 Objecet를 2개의 refer가 보고있다.
        //Strong과 soft
        strong = null;
        //이제는 soft만 보고있다.
        //메모리가 부족하면 지워진다.

        System.gc();
        Thread.sleep(3000L);

        // 대부분 거이사라지지않는다.
        // 메모리가 충분해서
        System.out.println(soft.get());

    }
}
