package effective.java.item16;

/**
 * public class 에서는 public 필드가 아닌
 * 접근자 매서드를 사용하라.
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
