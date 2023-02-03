package effective.java.item31.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// 와일드카드 타입을 이용해 대량 작업을 수행하는 메서드를 포함한 제네릭 스택 (181-183쪽)
// E 라는게 타입의 상속구조와 관계없이 오로지 한타입을 지칭한다.
// 그래서 공변하지않는다. 그래서 Object 에 배열에다가 Integer 를 넣을수있다던가.
// 이런것들이 불가능하다. Object 배열을 선언하면 Object 밖에 못넣는다.
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
    // 배열 elements 는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
    @SuppressWarnings("unchecked") 
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size==0)
            throw new EmptyStackException();
        E result = elements[--size];
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

    // 코드 31-1 와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다! (181쪽)
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }

//      코드 31-2 E 생산자(producer) 매개변수에 와일드카드 타입 적용 (182쪽)
//    훨씬 유연해진다.
    // 생산자 = 뭔가 넣거나,쌓거나 하면 producer

    /**
     * 이건 쉽게 이해가 될듯
     * @param src
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // 코드 31-3 와일드카드 타입을 사용하지 않은 popAll 메서드 - 결함이 있다! (183쪽)
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }

    // 코드 31-4 E 소비자(consumer) 매개변수에 와일드카드 타입 적용 (183쪽)
    // 뭔가 빼거나 pop 하거나그러면 소비자.
    // pushAll 을 보면알수있듯이 E 의 하위타입들이 stack 에 쌓여있을수있다.
    // dst 를 여기서 좀더 유연하게 설계하려면 그상위타입들만 Collection 제네릭타입으로 가능하다는 사실을 안다.
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()){
            E pop = pop();
            dst.add(pop);
        }
    }

//    public void popAll(Collection<? extends E> dst) {
//        while (!isEmpty()){
//            dst.add(pop());
//        }
//    }
    // 제네릭 Stack을 사용하는 맛보기 프로그램
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Iterable<Double> doubles = Arrays.asList(3.1, 1.0, 4.0, 1.0, 5.0, 9.0);
        numberStack.pushAll(doubles);

        Collection<Object> objects = new ArrayList<>();
        Collection<Integer> objects1 = new ArrayList<>();
        Collection<Number> objects2 = new ArrayList<>();
        numberStack.popAll(objects);
//        numberStack.popAll(objects1);
        numberStack.popAll(objects2);

        System.out.println(objects);

        //PECS 팩스~ PECS 에 너무 얽매이지말자.
        /**
         * extends 와 super 를 사용하면 API 를 좀더 유연하게 설계할수있다는 점이다.
         */
    }
}
