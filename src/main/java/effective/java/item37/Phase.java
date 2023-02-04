package effective.java.item37;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// 코드 37-6 중첩 EnumMap 으로 데이터와 열거 타입 쌍을 연결했다. (229-231쪽)
public enum Phase {
    SOLID, LIQUID, GAS;
    public enum Transition {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        HAMSTER(SOLID, LIQUID);

//        // 코드 37-7 EnumMap 버전에 새로운 상태 추가하기 (231쪽)
//        SOLID, LIQUID, GAS, PLASMA;
//        public enum Transition {
//            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
//            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
//            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
//            IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;
        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // 상전이 맵을 초기화한다.
        // 재밋는건 groupingBy 사용했던건 Map<Object,Collection> 이고
        // 여기서는 Map<Object,Map<Object,Collection>> 을 원한게아니라 Map<Object,Map<Object,Object>> 를 원했기때문에 toMap 이 나왔다.
        private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values()).
                collect(
                        groupingBy(
                                t -> t.from,
                                () -> new EnumMap<>(Phase.class),
                                // 어쨋든 value 에는 List,Map,Set 이들어가서 중복값 처리를 여기서는 안해주는군 그러나 toMap 에서는 필요하다.
                                // HAMSTER 를 주목할것
                                toMap(
                                        t -> t.to, // key
                                        t -> t, // value
                                        (x, y) -> {
                                            System.out.println(x);
                                            System.out.println(y);
                                            return y;
                                        }, // 중복키 처리/ x 는 처음값, y 는 두번째값
                                        () -> new EnumMap<>(Phase.class)
                                )
                        )
                );


        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

    // 간단한 데모 프로그램 - 깔끔하지 못한 표를 출력한다.
    public static void main(String[] args) {
        for (Phase src : Phase.values()) {
            for (Phase dst : Phase.values()) {
                Transition transition = Transition.from(src, dst);
                if (transition != null)
                    System.out.printf("%s에서 %s로 : %s %n", src, dst, transition);
            }
        }
    }
}
