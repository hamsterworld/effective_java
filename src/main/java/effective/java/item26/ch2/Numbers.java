package effective.java.item26.ch2;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
    // 아래처럼 쓰면 Set 도 안정성이 깨진다.
    // (Set s1,Set s2)
    // s1.add 해보면 매개변수안에 Object 가 되어있는것을 확인해볼수있다.
    // s1.add("Type 안정성깨졋어~"); s1.add(1); s1.add(true);.. 등등 Raw Type은
    // 아무거나 다집어쳐넣을수있다.
    static int numElementsInCommon(Set<?> s1, Set<?> s2){
        // 하지만 Set<?> 하면 타입이 어떤게 올지모르겟지만,
        // 한종류를 담고있는 Set 이 들어오는것정도는 알수있다.
        // 그러나 비한정적 와일드 카드를 사용하면 그어떤것도 넣을수없다.
        // 근데 어떤종류겠지만 뭔지 모르니까 넣을수는없다. 오직 null 만 가능하다.
        // Raw Type 와 차이가 바로 안정성이다. 타입방어가 가능하다.
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


        // ? 는 가장범용적이다. 즉, 뭐든 담을 수있다.
        Set<?> mySet = set;
        Set<?> mySet1 = set1;
        // 다시말하면 mySet 은 위에서 처럼
        // Set<Integer> 도 받을수있고
        // Set<String> 도 받을수있다!
        // 왜냐 아무거나 받을수있는 Set<?> 이니까!
        // 야 그러면 애초에 Raw Type 쓰면되는거아니야?
        // 위에서 확인했듯이 안전하지않다.

        // 한정적 못받는다.
//        Set<String> stringSet = set;

        System.out.println(Numbers.numElementsInCommon(Set.of(1,2,3),Set.of(1,2)));
    }
}
