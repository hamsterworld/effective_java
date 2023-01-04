package effective.java.item14.ch1;

import java.math.BigDecimal;

/**
 * equals 랑 성격은 비슷하지만
 *
 * 다른점이라면 value class 같은 object 들의 순서를 비교할수있다.
 *
 * comparator 를 통해 구현된 compara 나 comparato 매서드는 equals 와달리 양수, 0 ,음수를 반환한다.
 *
 * comparator 를 구현할때 어떠한 규약을 따라야하는지 알아보자.
 */
public class Comparatorrr{

    public static void main(String[] args) {
        //BigDecimal 은 대표적으로 Comparator 를 구현하고있는 class 이다.
        BigDecimal n1 = BigDecimal.valueOf(344234888);
        BigDecimal n2 = BigDecimal.valueOf(36786785);
        BigDecimal n3 = BigDecimal.valueOf(897674333);
        BigDecimal n4 = BigDecimal.valueOf(36786785);

        //반사성
        System.out.println(n1.compareTo(n1));

        //대칭성
        System.out.println(n1.compareTo(n2));
        System.out.println(n2.compareTo(n1));

        //추이성
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        //일관성 n2랑 n4가같으니 n4로도 햇을때 n2햇던결과가 같아야한다.
        System.out.println(n4.compareTo(n2));
        System.out.println(n4.compareTo(n1));
        System.out.println(n2.compareTo(n1));

        //이건 지키면 좋고 안지켜도 되고. compareTo 가 0이면 equals 도 true 여야 한다.
        //안지켜지는 대표적인 예시
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.compareTo(oneZeroZero)); //Tree , TreeMap 은 CompareTo를 비교해서 값을 넣는다. 그래서 Collection 중에서
        //CompareTo를 이용해 값을 넣는애들은 위에가 안들어간다.
        System.out.println(oneZero.equals(oneZeroZero)); //순서가없는 컬렉션은 equals 를 사용하기때문에 애네는 둘다 들어간다.
        //그래서만약에 위 규약이 지켜지지않으면 문서화를 해두는것을 권장하고있다.


    }


}
