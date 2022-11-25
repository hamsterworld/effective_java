package effective.java.item14.ch2;

import org.jetbrains.annotations.NotNull;

public class Point implements Comparable<Point>{

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(@NotNull Point p) {
        int result = Integer.compare(x, p.x);
        if(result == 0){
            result = Integer.compare(y,p.y);
        }
        return result;
    }
}
