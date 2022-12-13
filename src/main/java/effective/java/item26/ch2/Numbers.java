package effective.java.item26.ch2;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
    //아래처럼 쓰면 Set 도 안정성이 깨진다.
    static int numElementsInCommon(Set<?> s1, Set<?> s2){
        // s1.add 해보면 매개변수안에 Object 가 되어있는것을 확인해볼수있다.
//        s1.add("안녕 안정성깨졋어~");
        // 즉, Raw 타입은 아무거나 추가할수있게된다. 위에처럼.

        // 하지만 Set<?> 하면 타입이 어떤게 올지모르겟지만 그것을 유지한다는것
        // 즉, 한종류를 담고있는 Set 이 들어오는것을 받아줄수있다.
        // 그러나 비한정적 와일드 카드를 사용하면 그어떤것도 넣을수없다 오로지 null 만 가능하다.
        // 그래서 안정성이 확보된다.
        int result = 0;
        for (Object o : s1) {
            if(s2.contains(o)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<String> set1 = new HashSet<>();


        // ? 는 가장범용적이다.
        Set<?> mySet = set;
        Set<?> mySet1 = set1;

        // 한정적 못받는다.
//        Set<String> stringSet = set;

        System.out.println(Numbers.numElementsInCommon(Set.of(1,2,3),Set.of(1,2)));
    }
}
