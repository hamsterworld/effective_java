package effective.java.item16.ch2;

/**
 * public field 는 성능 문제까지도 있다.
 * 어떻게 그게가능한가? 한번 알아보자.
 */
public class Point {

    public double x;
    public double y;

    public static void main(String[] args) {
        Point point = new Point();

        point.x = 10;
        point.y = 20;

        System.out.println(point.x);
        System.out.println(point.y);
    }
}
