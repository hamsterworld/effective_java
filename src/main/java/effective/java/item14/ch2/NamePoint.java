package effective.java.item14.ch2;

import javax.naming.Name;
import java.util.TreeSet;

//여기서 Comparable<NamePoint> 구현이 안된다
//왜냐하면 이미 위에서 Comparable<Point>로 구현하고 있기 때문이다.

//그럼 방법이없냐? 아니다 있다.
//해당 자료구조에서 그냥 comparable 을 구현하면되지만 추천하지않는다.

//equals 마냥 Composition 을 사용하는것.

public class NamePoint extends Point{

    private final String name;

    public NamePoint(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        //추천하지않는 방법.
        NamePoint p1 = new NamePoint(1, 0, "inseok");
        NamePoint p2 = new NamePoint(1, 0, "hamster");

        TreeSet<NamePoint> points = new TreeSet<>((NamePoint o1, NamePoint o2) -> {
            int result = Integer.compare(o1.getX(), o2.getX());
            if(result == 0){
                result = Integer.compare(o1.getY(), o2.getY());
                if(result == 0){
                    result = o1.name.compareTo(o2.getName());
                }
            }
            return result;
        });

        //이게 포인트에 정렬된 순서로 들어가게될것이다.
        points.add(p1);
        points.add(p2);

        System.out.println(points);

    }

}
