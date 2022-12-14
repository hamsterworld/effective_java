package effective.java.item10.ch3;

import effective.java.item10.ch2.Color;
import effective.java.item10.ch2.Point;
import org.junit.jupiter.api.Test;

import java.util.Set;


public class ColorPointTest {
    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0),new Point(0,1),new Point(1,1),new Point(0,0) );

    public static boolean onUnitCircle(Point p){
        System.out.println(p);
        return unitCircle.contains(p);
    }

    @Test
    void test(){

        Point p1 = new Point(1, 0);
        //Point p2 = new effective.java.item10.ch3.ColorPoint(1,0,Color.BLUE); --> 이렇게 못함 상속을 못받아서 그래서 asPoint 가 있는것
        Point p2 = new effective.java.item10.ch3.ColorPoint(1, 0, Color.BLUE).asPoint(); // colorPoint 이지만 point 로 볼수있는 방법을 준것이다.

        System.out.println(onUnitCircle(p1));
        System.out.println(onUnitCircle(p2));

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));

    }

}