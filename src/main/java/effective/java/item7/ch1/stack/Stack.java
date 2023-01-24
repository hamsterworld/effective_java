package effective.java.item7.ch1.stack;


import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * array,list,map,set 등과 같이 무언가를 담는것은 GC 의 대상이 되지않는다. 즉, 메모리를 직접관리한다.
 * collections 처럼 쌓아놓는 이러한것들은 주의해서 사용해야한다.
 * 그래서 collections 같은것들은 언제 우리가 null 처리를 해줘야하는가를 항상 염두해두면서 프로그래밍 할것.
 *
 * 책에서 설명하는 메모리 누수가 자주일어날수있는 3가지 ex) cache,listener,stack 과같은것도 결국에는
 * 무엇인가를 collections 나 array 로 쌓아놓는다!
 *
 * 1. null 처리
 *  다 쓴 객체를 처리하는 가장 명시적인 방법이 바로 null 처리이다.
 *
 * 2. scope 밖으로 빼내기
 *  다 쓴 객체를 처리하는 가장 일반적인 방법
 *
 * 3. 직접 관리
 *  예를 들면, LRU Cache 라고해서 가장 최근10개만 살리겠다.
 *  map 에서 size 가 11개가되면 가장오래된것을 remove 해줘서 삭제한다. (필요하면 null, scope 빼기 등을 활용할수도있을듯)
 *
 * 4. 특정한 자료구조를 사용한다.
 *  weakHashMap 과같은것이 예시가 될수있다.
 *
 * 5. backgroundThreadPool 을 사용해서 주기적으로 지워준다.
 *  비슷한 내용이긴한데 말그대로 주기적으로 clean-up 을 해준다.
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

//    public Object pop(){
//        if(size == 0)
//            throw new EmptyStackException();
//        return elements[--size]; //언젠간 메모리가 꽉차버릴것이다.
//    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두배씩 늘린다.
     */
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }

//     코드 7-2 제대로 구현한 pop 매서드 (37쪽)
    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for(int i =0;i<1000000; i++){
            stack.push("" + i);
        }

        while(true){
            System.err.println(stack.pop());
        }
    }

}
