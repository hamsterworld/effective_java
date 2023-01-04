package effective.java.item16.ch1;

import effective.java.item16.ch2.Button;

import java.util.ArrayList;
import java.util.List;

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


    /*
        나중에 generic 쪽에 넣자.
     */
    public static void main(String[] args) throws ClassNotFoundException {

//        Class<?> 안녕 = Class.forName("안녕");
//        Class 반가워 = Class.forName("반가워");
//
        Class<Point> 햄스터 = (Class<Point>) Class.forName("햄스터");
//        Class<Object> 훅훅 = (Class<Object>) 햄스터;
//        Class<? extends Point> 햄스터1 = 햄스터;
//        Class<Button> button = (Class<Button>) Class.forName("button");
//        Class<? extends Point> 햄스터2 = button;
//
//        List<String> list= new ArrayList<>();
//        List<Object> list1 = (List<Object>)list;
//
//        List<?> list2 = new ArrayList<>();
//        List<String> list3 = (List<String>) list2;
//
        List<? extends Number> list4 = new ArrayList<>();
        List<Integer> list5 = (List<Integer>) list4;
//        List<String> list6 = (List<String>) list4;
//
//        Integer[] list7 = new Integer[10];
//        Object[] list8 = list7;

    }
}
