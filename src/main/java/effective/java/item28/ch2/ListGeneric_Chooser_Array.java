package effective.java.item28.ch2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListGeneric_Chooser_Array<T> {

    private final List<T> choiceList;

    public ListGeneric_Chooser_Array(Collection<T> choiceList) {
        this.choiceList = new ArrayList<>(choiceList);
    }

    public T choose(){
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("h", "asd", "34", "fde", "feg1", "ff2");

        ListGeneric_Chooser_Array<Integer> chooser = new ListGeneric_Chooser_Array<>(intList);

        for(int i =0;i<10;i++){
            Integer choice = chooser.choose();
            System.out.println(choice);
        }
    }

    /**
     * 결론은 성능이 그렇게 중요시여기는곳이아니라면
     * List 를 사용하자.
     */
}
