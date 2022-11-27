package effective.java.item13.exception;

/**
 * uncheckedException 굳이 편하다고 사용한다는 이유가 되면안된다.
 * checkedException 은 이자체로 프로그래밍이다.
 * 사용자가 인지할수있는것을 주는것이다.
 * 정보를 주는것이다.
 * 명시적으로 알수있다.
 * 내가 라이브러리 사용할때를 생각해보자. Exception 이 날수잇는곳을 알수있다.
 * Client 한테 알려줄수있다. 명확한 장치
 *
 * nuCheckException 은 왜? Client 쪽에서 이예외가 발생하면 할수있는게없다.
 * 그래서 코드만 번잡하게 할빠에 그냥 아무것도 하지마라라고 해서 만든게 unChecked 의 의도인것같다.
 *
 * 즉, 선택의 기준은 Client 한테 복구할수있는 방법이 있는예외라면 checked 사용하는것이 낫다.
 * 무조건 unchecked 를 선호하는것을 지양하라.
 *
 */
public class MyApp {

    /**
     *
     * @param name
     * @throws MyException
     */
    public void hello(String name) throws MyException {
        if (name.equals("푸틴")) {
            throw new MyException();
        }

        System.out.println("hello");
    }

    public static void main(String[] args) {
        MyApp myApp = new MyApp();
        try {
            myApp.hello("푸틴");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
