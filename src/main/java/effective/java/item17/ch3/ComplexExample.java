package effective.java.item17.ch3;

// 생성자가 private 면 상속이 안된다.
// 사실상 final 이라고도한다.
// 그러나 내부에서는 상속이 가능하므로
// static factory 에서 다른구현체를 return 할수있고 그런것.
public class ComplexExample{

    // 여기서 static factory 가 유연하다는것이 나온다.
    // complex 타입만 받으면되지만 구현체가 뭐가 넘어오는지 전혀모른다.
    // 되게 유연하다.
    // 또 static factory 가 캐싱해놓을수도있어서 성능에도 좀더 유리하다.
    public static void main(String[] args) {
        Complex complex = Complex.valueOf(1, 2);
    }

    //static 은 override 가 안된다.
    void method(){

    }

    /**
     * + 모든 field 들은 모두 final 할필요는 없지만
     * 되도록이면 외부에 공개되는 것들은 final 로하는것이 좋다.
     * 그리고 외부에 공개되지않는 final 로 하고싶지않다면 안해도된다 ex) hashcode
     * 또는 만드는데 비용이 많이 드는 값들 같은경우 lazy-loading 을하고싶다면 final 을 굳이 안해도된다.
     */
}
