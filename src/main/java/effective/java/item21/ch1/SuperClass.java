package effective.java.item21.ch1;
/**
 * default method 가 runtime 을 일으킬수있다.
 */
public class SuperClass {

    // SubClass 가 interface 도 구현해놔서
    // default method 를 이 SuperClass 가 overriding 하고있다.
    public void hello(){
        System.out.println("hello class");
    }

    // 얘가 바로 버그 ㅇㅇ
//    private void hello(){
//
//    }

}
