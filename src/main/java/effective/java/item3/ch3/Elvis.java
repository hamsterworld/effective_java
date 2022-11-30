package effective.java.item3.ch3;


/**
 *  정적 팩토리의 메서드 참조를 공급자로 사용할수있다.
 *  이방법으로하면 단점은 동일 1.test문제 2.리플렉션문제 3.직렬화역직렬화문제
 *  해결책도 전부 동일하다.
 */
public class Elvis implements Singer {

    private static final Elvis Instance = new Elvis();

    private Elvis() {

    };

    //정적팩토리 매서드
    public static Elvis getInstance(){
        return Instance;
    }

    public void leaveTheBuilding(){
        System.out.println("Whoa baby I'm outta here!");
    }

    public void sing(){
        System.out.println("I'll have a blue~ Christmas without you~!");
    }


    public static void main(String[] args) {

        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        System.out.println(Elvis.getInstance());
        System.out.println(Elvis.getInstance());

        //private 생성자를 통해 static factory 패턴을 쓰면 장점

        //장점1.
        //만약에 정적팩토리에서 return new Elvis()로 바꾸면 새롭게 만들수있다.
        //이것이 매서드를 사용하니까 쉽게 변경할수있는것이다.
        //
        //장점2.
        //제네릭 타입을 쓸때 (meteElvis 참조)
        //
        //장점3. (Concert 에서 start 참조)
        //정적팩토리의 매서드참조를 공급자로 사용할수있다.


    }

}
