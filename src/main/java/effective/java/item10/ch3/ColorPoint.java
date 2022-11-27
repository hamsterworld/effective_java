package effective.java.item10.ch3;

import effective.java.item10.ch2.Color;
import effective.java.item10.ch2.Point;

import java.util.Objects;

/**
 * 상속을 해서 새로운 필드를 추가하는경우
 *  equals를 만족시킬방법이없다.
 *  그럴땐 새로 class를 만들고 컴포지션을 추가해라.
 * 아래처럼 이렇게 필드를 받는것.
 * 이를 통해 아까처럼 치환법칙위반에서 헤어나올수있다.
 */
public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x,int y, Color color) {
        this.point = new Point(x,y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * point를 노출시킬수있다.
     */
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ColorPoint)){
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);

    }


}
