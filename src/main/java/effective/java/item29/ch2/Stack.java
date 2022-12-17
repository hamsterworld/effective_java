package effective.java.item29.ch2;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E extends Number> {

    //에서 <E> 에서 <E extends Number> 로 변경되었을때 E 가 Object[] 가아닌 Number[] 로 바뀐다.
//     private E[] elements;
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;


     // SuppressWarnings 를 사용한 근거가 된다.
    public Stack() {
        // Object[] 에서 E[] 로 캐스팅은 굉장히 위험
        // 이것은 ClassCastException 을 발생시킨다.
        // 근데 애초에 부모 -> 자식으로는 형변환 불가능하긴함.
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        elements = (E[]) new Number[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        // 여기서 이제 e 를 통해 Number 의 기능을 사용가능 왜냐?
        // 한정적 타입 매개변수를 사용하면 Object 가아닌 Number 로 된다.
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
//        E result = elements[--size];
        @SuppressWarnings("unchecked") E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
//        Stack<Float> rrrrrr = new Stack<>();
        Stack<Integer> rrrrrr = new Stack<>();
        for (Integer arg : List.of(1, 2, 3))
            rrrrrr.push(arg);
        while (!rrrrrr.isEmpty())
            System.out.println(rrrrrr.pop());

        Number[] elements1 = rrrrrr.elements;
        Integer[] elements2 = rrrrrr.elements;

    }
}
