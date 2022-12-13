package effective.java.item28.ch2;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser_Array {

    // Integer[],String[] 이런건 아마 문제가 안될거다.
    // 그러나 Object[] 이런것들은 문제가 될거다. 근데 외부에서 여러가지 타입을 지원해야하니까 그래서 Object[]를 썻다고해보자.
    private final Object[] choiceList;

    public Chooser_Array(Collection choiceList) {
        this.choiceList = choiceList.toArray();
    }

    public Object choose(){
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return choiceList[rnd.nextInt(choiceList.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("h", "asd", "34", "fde", "feg1", "ff2");

        Chooser_Array chooser = new Chooser_Array(intList);

        for(int i =0;i<10;i++){
            // 배열이 가지고 있는 문제이다.
            // Object 를 String 으로 넘겻는데 Client 에서 Number 로 캐스팅 한다면 문제가 생길거다.
            Number choice = (Number)chooser.choose();
            System.out.println(choice);
        }
    }

    // 그래서 위처럼 범용적인 class 를 만드는것에 있어서 타입형변환의 문제를 재네릭이 해결해줄수있다.
    /**
     * 그래서 이런 다양한 타입을 지원하고, 타입형변환을 지원하고, 타입안정성까지 지원하기 위해서 나온게
     * 바로 Generic 이다.
     */
}
