package effective.java.item19;

// 따라하지 말것
public class Super {

    //생성자가 재정의 가능한 매서드를 호출하면 안된다.
    public Super() {
        overrideMe();
    }

    public void overrideMe(){

    }
}
