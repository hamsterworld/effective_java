package effective.java.item31.ch3;

/**
 * ? 는 불특정타입이라고 생각하면 편하다.
 *
 * E,V... 등등은 특정타입이라고 생각하면 편하다.
 */

import effective.java.item31.ch2.exmaple.Box;
import effective.java.item31.ch2.exmaple.IntegerBox;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

// 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드 (189쪽)
public class Swap {

    // ? 로변경하게되면 넣을수가없다. 전달을 할수가없다.
    // ? = 비한정적타입 = 모른다.
    // E = 특정타입 = 안다.
    // <?> 하면 깔끔해지지만 넣는걸못한다 꺼내는건 가능하다.
    // 그래서 무엇인가를 꺼내기만 할거라면 <?> 써도 상관없다.
    // <?> 써서 무엇인가를 넣을려면 결국 swapHelper 매서드같은게 필요하다
    // 근데 이거 쓸빠엔 그냥 <E> 하는게 낫다.

    /**
     * <?> 만 쓸꺼면 꺼낼때만 써야되는데 그것도웃기다.
     * 꺼낼때는 ? 쓰고 넣을땐 <E>
     *     차라리 코드 컨밴션을 PECS 원칙에따라서 ? 을 쓰는게낫고
     *     ? 만쓰는건 조금 별로라고 생각한다.
    */
    public static <E> void swap(List<E> list, int i, int j) {
//    public static void swap(List<?> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
//        swapHelper(list, i, j);
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
//    private static <E> void swapHelper(List<E> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i)));
//    }

    public static void main(String[] args) {
        // 첫 번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() - 1);
        System.out.println(argList);

//        Box<Integer> myBox = new IntegerBox(10,"keesun");
//        myBox.change(100);

        // ? 를 쓰면 나도 모르는 타입이라는것이다. 물론 뒤에 value 보면 int 인거알지
        // 객체는 알지만 <?> 너는 모른다.
        // 런타임에서는 알게되겟지만 지금은 capture of ?
        // 너가 원하는 int 를 넘길지를 보장을 못한다.
        // 오로지 null 만 허용한다.
        Box<?> myBox = new IntegerBox(10,"keesun");
//        myBox = new Box<>("안녕");
//        myBox.change("안녕2");
//        Box<Integer> myBox = new IntegerBox(10,"keesun");
//        myBox.change(100);
        myBox.change(null);

    }
}
