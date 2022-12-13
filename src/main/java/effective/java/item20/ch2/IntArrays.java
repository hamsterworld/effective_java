package effective.java.item20.ch2;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * interface 는 interface 만의 장점이 있다. (default method)
 * abstract class 만의 장점도 있다. (interface 는 field 관련된것은 못하나 얘는 할수있다.)
 *
 * 그래서 interface 에서 default 로 구현해줄수잇는 것들은 구현해주고
 * default 로 구현할수없는것을 abstract class 로 구현해줄수있다. 이것을 skeleton class 라고도한다.
 *
 * 이게 왜 skeleton 이냐? 추상클래스가 interface 의 일부로직은 구현하는데
 * 하위 클래스에서 오버라이딩할수있는 몇몇부분은 남겨두는 것이다.
 */
// 코드 20-1 골격 구현을 사용해 완성한 구체 클래스
public class IntArrays {

    static List<Integer> intArrayAList(int[] a){

        Objects.requireNonNull(a);

        // 구현할 method 들이 너무 많다.
        // 즉 List Interface 를 모두 구현하기에는 꽤나 부담이 된다.
//        return new List<Integer>() {
//
//        }

        //        AbstractList<Object> hamster = new AbstractList<>() {
//            @Override
//            public Object get(int index) {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//        };

        // 그러나 추상클래스인 skeleton class 통해 구현하면
        // 전부다 구현하지않아도 일부분만 재정의해서
        // List 를 손쉽게 구현할수있다.
        return new AbstractList<Integer>() {

            @Override
            public Integer get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Integer set(int i,Integer val){
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
        };

    }

}
