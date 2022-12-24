package effective.java.item28.ch2;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generic_Chooser_Array<T> {


    private final T[] choiceList;

    @SuppressWarnings("unchekced")
    public Generic_Chooser_Array(Collection<T> choiceList) {
        // 컴파일 경고가 뜬다. 이유는 컴파일러가 타입안정성을 보장해주지 못하기때문이다.
        // 컴파일 하고나면 일단 Generic 은 전부 사라진다.
        // 그래서 형변환해야되는 타입과 toArray 로 만들어진 Type 과 변환이 되는지 보장을 못하기때문이다.
        // 원래는 List<Integer> list 이렇게 해서
        // list.add("안녕"); 하면 타입보장을 해줬다.
        // 그러나 이런경우에는 Object[] 로 반환되고 T[] 로 다시하는데
        // 안에있는 Object element 들이 T 와 호환되는지 컴파일단계에서는 보장을 해줄수가없다.
        // 그러나 우리는 안다 이게 보장된다는것을.
        // 당연히 Collection<T> 해가지고 오면 당연히 T 에관한 element 를 array 에 넣겟지. 내가 보장할수있다는것.
        // 그래서 suppressWarnings 를 쓰는것.
        this.choiceList = (T[]) choiceList.toArray();
    }

    public T choose(){
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return choiceList[rnd.nextInt(choiceList.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("h", "asd", "34", "fde", "feg1", "ff2");

        Generic_Chooser_Array<Integer> chooser = new Generic_Chooser_Array<>(intList);
        Generic_Chooser_Array chooser_array = new Generic_Chooser_Array<>(stringList);

        for(int i =0;i<10;i++){
            Integer choice = chooser.choose();
            Integer choose = (Integer)chooser_array.choose();
            System.out.println(choose);
            System.out.println(choice);
        }
    }

    //그래서 위처럼 범용적인 class 를 만드는것에 있어서 타입형변환의 문제를 재네릭이 해결해줄수있다.
}
