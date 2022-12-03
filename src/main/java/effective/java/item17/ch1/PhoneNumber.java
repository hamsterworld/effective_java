package effective.java.item17.ch1;

/**
 * 어쨋든 불변은 프로그래밍에서 굉장히 이점이 많다.
 * 1.멀티스레딩 환경에서 안전하다.
 * 2.성능에도 좋다 => 변하지않으니 캐싱해서 사용
 *
 * 불변클래스만드는 5가지 규칙
 * 1. 객체 상태를 변경하는 매서드를 제공하지않는다. => setter 제공하지않는다.
 * 2. 상속을 할수없도록 만든다.
 *    1) final class 가 아니므로 상속이 된다.
 *    2) public method 를 가지고있기때문에 상속할수있다.
 * 이번 강의에서는 상속이 어떻게 불변을 깨뜨리는지 알아볼것이다.
 *
 * => final class , final field 를 선언하자.
 *
 * 3.final 은 사용할수있으면 최대한쓰자 일단 성능적인 장점이 있다.
 * 프로그램을 견고하게 만들수있다.
 *
 * 4. 모든필드는 private 로 선언하자.
 *
 * 5.자신 외에는 내부의 가변 컴포넌트에 접근할수없도록 한다.
 * => 이게무슨말일까?
 */
public class PhoneNumber {

    private short areaCode;
    private short prefix;
    private short lineNum;


    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public void setAreaCode(short areaCode) {
        this.areaCode = areaCode;
    }

    public void setPrefix(short prefix) {
        this.prefix = prefix;
    }

    public void setLineNum(short lineNum) {
        this.lineNum = lineNum;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }
}
