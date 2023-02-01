package effective.java.item27.ch1;

import java.util.Arrays;

/**
 * 왜 이 경고를 숨기는 짓을 해야할까?
 * 왜 권장할까?
 * 내가 알고있는 컴파일경고외에 다른 경고가 발생하면
 * 알수있다.
 *
 * suppressWarnings 를 하지않으면
 * 내가 이미 알고있음에도 불구하고 컴파일 경고가 발생하면 내가이미 아는부분에서 발생한건지
 * 모르는 부분에서 발생한건지 알기가 힘들다.
 */
public class ListExample {

    private int size;

    Object[] elements;

    public <T> T[] toArray(T[] a){
        if(a.length < size){
            /*
                왜 suppressWarnings 을 붙인 이유도 꼭 부가적으로 넣어주자.
                ~~ 이래저래해서 type 은 안정하다~
             */
            @SuppressWarnings("unchecked") // 매서드에다가도 붙일수있지만 가능한 좁은 범위에 붙이자.
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass()); // Object[] 이므로 뭐가됫든지간에 변환이 가능한건 팩트다.
                                                                            // Array 는 변환이 가능하기때문 제네릭은 변하지않는다.
                                                                            // a.getClass 때문에 T[] 라는것을 보장할수있기때문에 casting 도 가능하다.

            return result; // annotation 은 return 에다가 못붙이므로.
        }
        System.arraycopy(elements,0,a,0,size);
        if(a.length > size){
            a[size] = null;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
