package effective.java.item7.ch1.stack;


import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 1. 객체에 대한 레퍼런스가 남아있다면 해당 객체는 가비지컬렉터에 대상이 되지않는다.
 * (다쓴 객체를 항상 해제하지마라. -> null로 처리하는것인데 예외적이라햇지만 흔하다.)
 * 2. 메모리를 직접관리하는 클래스라면 메모리 누수에 주의하라
 * ex)stack, cache, listener or callback --> 일단 stack, cache, listener 가 대표적인 메모리누수의 예시들
 * 위의 예시들은 공통적으로 객체를 쌓아두는 공간이 있다는 것이다.
 * 그래서 이객체를 어떻게 정리할거냐? 이정리하는 방법들도 3가지이다.
 *
 * 첫번째, 여기 Stack 예시에서처럼 null을 명시해주는것이다.
 *
 * 두번째, cache 는 Stack 의 pop 마냥 빼는 기능이없다면?
 * 물론 cache 도 데이터가 변경되면 없애야되긴한다. 일단 이번예제코드는 쌓이기만한다고생각해보자.
 * 그래서 여기서 쓰는게 weakHashMap 이다.
 * 레퍼런스에는 strong ,soft ,weak, phantom 이렇게 4가지가 있다.
 * 그중에 weak 레퍼런스를 사용할거고 weak 레퍼런스를 key 로 사용하는놈을 weak HashMap 이라고 한다.
 * 이놈의 특징은 key가 더이상참조가안되면 weak 레퍼런스빼고 더이상참조가 안되면
 * 그 key 를 가지고있는 value 를 Map 에서 빼준다.
 *
 * 세번째, 참조 객체를 null 처리하는것은 예외적이다. 가장좋은 방법은 유효범위 밖으로 밀어내는것이다.
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size]; //언젠간 메모리가 꽉차버릴것이다.
    }

    public Object pop2(){
        return elements[100];
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두배씩 늘린다.
     */
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }

    // 코드 7-2 제대로 구현한 pop 매서드 (37쪽)
//    public Object pop(){
//        if(size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; //다 쓴 참조 해체 //물론 result를 가져간곳에서 조차 다쓴다면 아래
////        의 pop을했던곳도 다른 바운더리를 벗어나면 그객체의 생명주기는 끝난다.
////        결국에는, null해준것처럼 되긴한다. 그래서 null처리를 해주는것은 되게 명시적인 방법이다.

////        그래서 GC의 대상에서 벗어나는애들은 elements 처럼 무엇인가를 담고잇는 경우
////        ex)List,Set,Map 같은경우이다. 이렇게 메모리를 직접관리하는 경우 메모리 누수에 주의해야한다.
////        그래서 언제 바운더리를 벗어나게하거나 null처리를 해줘야하는가 항상 염두하자.
////        null은 되게 명시적인 방법이다.
////
////        cache역시도 메모리누수를 발생시키는 주범이다.
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for(int i =0;i<1000000; i++){
            stack.push("" + i);
        }


        while(!(stack.size == 0)){
            System.err.println(stack.pop());
        }

//        stack = null;

        System.out.println(stack.pop2());

        while(true);


    }

}
