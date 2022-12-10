package effective.java.item10.ch2;

public class Point {
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    //깔끔한 코드
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Point)){
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    //추이성 위반때메 아래와같은 코드가나왔다
    //그러나 이것은 리스코프 치환법칙에 위배된다.
//    @Override
//    public boolean equals(Object o){
//        if(o == null || o.getClass() != getClass()){
//            return false;
//        }
//
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }



}
