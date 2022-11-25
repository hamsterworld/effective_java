package effective.java.item10.ch7;

import effective.java.item10.ch2.Color;

public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //잘못된코드 대칭성 위배
//    @Override
//    public boolean equals(Object o){
//        if(!(o instanceof ColorPoint)){
//            return false;
//        }
//
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    //이번엔 타입까지 고려해서 햇더니 추이성이 위배된다.
    //이거 굉장히 위험한 코드다.
    //같은 계층에 있는 상속받은애가잇다면 서로 호출하면서 스텍오버플로우가 난다.
    @Override
    public boolean equals(Object o){

        if(!(o instanceof Point)){
            return false;
        }
        //일반 Point면 색상을 무시하고 비교한다.
        if(!(o instanceof ColorPoint)){
            return o.equals(this);
        }
        //o가 ColorPoint면 색상까지 비교한다.
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
