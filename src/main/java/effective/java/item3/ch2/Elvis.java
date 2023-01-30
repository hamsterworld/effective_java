package effective.java.item3.ch2;

import java.io.Serializable;

/**
 *  리플렉션을 이용하면 싱글톤이 깨지게된다.
 */
public class Elvis implements Serializable {

    public static final Elvis Instance = new Elvis();

    //리플렉서에서 추가적인 instance가 생성되는것을 막는다.
    private Elvis() {
//        throw new IllegalArgumentException("꺼져");
    };

    public void leaveTheBuilding(){
        System.out.println("Whoa baby I'm outta here!");
    }

    public void sing(){
        System.out.println("I'll have a blue~ Christmas without you~!");
    }

    public static void main(String[] args) {
        effective.java.item3.ch1.Elvis elvis = effective.java.item3.ch1.Elvis.Instance;
        elvis.leaveTheBuilding();
    }

    private Object readResolve(){
        return Instance;
    }


}
