package effective.java.item10.ch2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Set;

class ColorPointTest {

    @Test
    @DisplayName("대칭성 위반사례")
    void test(){
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p.equals(cp) + " " + cp.equals(p));
    }

    @Test
    @DisplayName("추이성 위반사례")
    void test2(){
        ColorPoint p1 = new ColorPoint(1, 2, Color.GREEN);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }

    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0), new Point(0, 1),
            new Point(-1, 0), new Point(0, -1));

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }

    @Test
    @DisplayName("리스코프 치환법칙위배")
    void test3(){
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);

        Iterator<Point> iterator = unitCircle.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //true 를 출력해야한다.
        System.out.println(onUnitCircle(p1));

        //true 를 출력해야하지만 Point 의 equals 가 getClass 를 사용해 작성되었다면 그렇지않다.
        System.out.println(onUnitCircle(p2));

        //위에가 리스코프치환법칙이 위배되는이유
        //같은 클래스가 왓을땐 true 고 다른하위클래스가왓을땐 false 가 나온다.
        //어쨋든 같은타입인데 하위타입이 상위타입을 대체하지못한다. 리스코프치환법칙에 위배된다.
        //시멘틱이 깨졋다. 의미가 유지되지않는다.

        //어쨋든 상속을 하게되면 equals 문제가 많이 복잡해진다.
        //counterpoint 는 필드를 추가안했다.
        //그러나 colorPoint 는 필드를 추가해버렸다.
        //이것들이 문제다.
        //필드를 추가했을때는 안전하고 equals 의 규칙을 모두 준수하는 것은 없다.
        //자바에서도 이미 코드가 깨져있다.
    }
}