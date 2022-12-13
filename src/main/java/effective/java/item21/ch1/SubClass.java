package effective.java.item21.ch1;

public class SubClass extends SuperClass implements MakerInterface{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.hello(); // -> 어떤 default 를 호출할까?
        // 이전시간에 언급했던것을보면
        // Class 가 Interface 를 항상 이겨야한다.
        // 그래서 Superclass 것을 접근하려고하지만
        // private 라서 그것을 사용하려고하니 에러가 난다.
        // 사실상 버그다.
        // 이것이 default method 가 runtime 중에 발생하는 에러다.
        // 개발자는 항상 compile error 를 선호해야한다.
    }
}
