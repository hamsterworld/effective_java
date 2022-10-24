package effective.java.item3.ch1;

/**
 *  생성자나 private 타입으로 싱글턴임을 보장하라!
 */
public class Elvis implements IElvis{

    public static final Elvis Instance = new Elvis();

    private Elvis() {

    };

    //장점
    // 간결하고 싱글턴임을 API에 들어낼 수 있다. --> private 이므로, javadocs로 편하게 드러낼수있다.

    public void leaveTheBuilding(){
        System.out.println("Whoa baby I'm outta here!");
    }

    public void sing(){
        System.out.println("I'll have a blue~ Christmas without you~!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.Instance;
        elvis.leaveTheBuilding();
    }




}
