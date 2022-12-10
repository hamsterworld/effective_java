package effective.java.item10.ch7;

public class SmellPoint extends Point{

    private String smell;

    public SmellPoint(int x, int y,String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object o){

        if(!(o instanceof Point)){
            return false;
        }
        //일반 Point 면 색상을 무시하고 비교한다.
        if(!(o instanceof SmellPoint)){
            return o.equals(this);
        }
        //o가 ColorPoint 면 색상까지 비교한다.
        return super.equals(o) && ((SmellPoint) o).smell == smell;
    }

}
