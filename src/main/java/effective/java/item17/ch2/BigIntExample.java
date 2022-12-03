package effective.java.item17.ch2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * 4. 불변 객체끼리는 데이터를 공유해도된다.
 * + 객체를 만들때 불변객체들로 구성하면 장점이 많다 대표적으로 Set
 */
public class BigIntExample {

    public static void main(String[] args) {

        BigInteger ten = BigInteger.TEN;

        // negate 를 쓰면 반대로 바꿔준다. 10이 -10으로..
        BigInteger minusTen = ten.negate();
        // 안에 내구 구조를 보면 이렇게되어있다.
        // new BigInteger(this.mag,-this.signum);
        // ten 도 this.mag 사용 minusTen 도 this.mag 사용
        // 어? this.mag 가 바뀌면 이것을 공유하는 ref 는 전부 값이 바뀌겟네?
        // 맞다. 그러나 불변객체의 데이터를 불변 객체가 사용하고있으므로 안전하다.
        // 그래서 데이터 공유가 가능하다는것.
        // 즉, 불변객체는 내부데이터까지 공유해서 사용할수있다는것
        // 만약에 불변객체가 아닌애한테 내부데이터를 공유한다면
        // 다른 객체에서 내부데이터를 변경하면 불변객체 내부의 데이터도 변경되므로
        // 불변객체끼리만 데이터를 공유하자!
        System.out.println(minusTen);

        // Set 의 구성요소가 같아야 두 Set 이 같다고 할수있다.
        Set<Integer> numbers = Set.of(1,2,3);
        //위와같은 경우는 Integer 가 들어갓으므로 바뀔여지가 없다.

        //아래 처럼한다고해도
        //final 로 해도 Set 의 내부가 변할수있다.
        final Set<Point> pointSet = new HashSet<>();
        Point point = new Point(1, 2);
        pointSet.add(point);

        point.setX(2);
        // 이렇게 내부가 변할수있다.
        // 그래서 Set 이런것도 불변으로 구성하면 Set 도 불변이 될확률이 높다.
        // + 추가적으로, Set 자체에 넣고 빼고 추가같은것도 불변객체로 wrapper 해주면 더 좋을것같다.


    }

}
