package effective.java.item10.ch7;

import effective.java.item10.ch2.Color;

public class Test {
    public static void main(String[] args) {
        SmellPoint p1 = new SmellPoint(1, 0, "sweat");
        ColorPoint p2 = new ColorPoint(1, 0, Color.BLUE);
        System.out.println(p1.equals(p2));
    }

}