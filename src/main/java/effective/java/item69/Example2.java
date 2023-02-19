package effective.java.item69;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 잘 설계된 API 라면 클라이언트가 정상적인 제어흐름에서 예외를 사용할 일이 없게 해야한다.
 */
public class Example2 {
    // 특정상태에서만 호출할수있는 상태의존적 매서드를 제공하는 클래스는
    // 상태 검사 메서드도 함께 제공해야한다.
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        for (Iterator<Object> i = list.iterator(); i.hasNext();){
            Object next = i.next();
            //...
        }
        // next = 상태의존메서드 hasNext = 상태검사메서드
        // iterator 가 상태검사메서드를 제공하지않앗다면 우리가 대신해야만햇을것이다.


        // 아래처럼 작성하지말아라!
        try{
            Iterator<Object> i1 = list.iterator();
            while(true){
                Object next = i1.next();
            }
        } catch (NoSuchElementException e){
            System.out.println(e);
        }
    }
    // 상태검사메서드대신
    // Optional 을 대신 사용할수도있다!
}
