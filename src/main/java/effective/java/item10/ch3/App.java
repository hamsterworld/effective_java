package effective.java.item10.ch3;

import effective.java.item10.ch2.Color;
import effective.java.item10.ch2.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {

//        List<Point> unitCircle = new ArrayList<>();
//        unitCircle.add(new Point(1,0));
//        unitCircle.add(new Point(1,1));
//        unitCircle.add(new Point(0,1));
//        unitCircle.add(new Point(0,0));

        Set<Point> unitCircle = Set.of(
                new Point(1, 0));

        Point p1 = new Point(1, 0);
        //Point p2 = new effective.java.item10.ch3.ColorPoint(1,0,Color.BLUE); --> 이렇게 못함 상속을 못받아서 그래서 asPoint가 있는것
        Point p2 = new effective.java.item10.ch3.ColorPoint(1, 0, Color.BLUE).asPoint(); // colorPoint이지만 point로 볼수있는 방법을 준것이다.

//        System.out.println(unitCircle.contains(p1));
//        System.out.println(unitCircle.contains(p2));
//
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));
    }
}
