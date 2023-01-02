package effective.java.item16.ch1;

public class privatePoint {
    private double x;
    private double y;

    public double getX() {
        //부가 작업도 가능
        return x;
    }

    public void setX(double x) {
        //부가 작업도 가능 ex) validation 이라던지 등등..
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // 물론 set 은 만들기 권장하지않는다.
    // 어쨋든 private field 를 설정하면 좀더 캡슐화를 더잘할수있다.

    /**
     * package-private 면 우리만 사용하는거거나 우리회사만 쓰는거기때문에
     * 굳이 private field 안해도 괜찮다.
     * 그러나 필자나 나나 여전히 private field 를 해서
     * get,set 등등 접근매서드를 사용해서 여러부가로직도 추가하는게
     * 더나은것같다.
     */
}
