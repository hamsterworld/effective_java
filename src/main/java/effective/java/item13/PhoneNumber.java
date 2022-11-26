package effective.java.item13;

import java.util.HashMap;
import java.util.Map;

/**
 * clone 의 규약
 * 1. x.clone() != x 반드시 true
 * 2. x.clone().getClass() == x.getClass() 반드시 true
 * 3. x.clone().equals(x) true가 아닐수도있다.
 *
 * 불변 객체라면 다음으로 충분하다. final class
 * cloneable 인터페이스를 구현하고
 * clone 매서드를 재정의한다.
 */
public final class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
        System.out.println("constructor is called");
    }

    //카피 생성자
    public PhoneNumber(PhoneNumber phoneNumber) {
        this(phoneNumber.areaCode, phoneNumber.prefix, phoneNumber.lineNum);
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

//     코드 13-1 가변 상태를 참조하지 않는 클래스용 clone 메서드 (79쪽)
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // 일어날 수 없는 일이다.
        }
    }

    //상속받아서 오버라이딩할때 상위 클래스의 매서드 접근지시자보다
    //더넓거나 같아야한다.
    //그래서 위에 public 이 가능한것
    //protected 로 해도되지않냐?
    //쓸모가없어진다.
    //하위클래스에서만 사용할수있는 놈이된다.
    //누군가가 phoneNumber 의 clone 을 사용할텐데
    //그게 전부 pn의 하위클래스는 아닐것이다.
    //그래서 보통은 public 이다.

    //return 타입또한
    //내가 상위 매서드의 오버라이딩하는 return 타입의 하위클래스도 인정한다.
    //이렇게 사용하면 굳이 타입캐스팅을 하지않아도된다. 유용하다.

    //그리고 원래 CloneNotSupportedException 은 CheckedException 인데
    //다시 unCheckedException 으로 잡아줘서 사용한다.
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber(707, 867, 5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(pn, "제니");

        //생성자를 통해 만들지는 않는다. clone 이라는 매서드를 통해만들어진다. 이정도로만 알아두자.
        PhoneNumber clone = pn.clone();
        System.out.println(m.get(clone));

        System.out.println(clone != pn); // 반드시 true
        System.out.println(clone.getClass() == pn.getClass()); // 반드시 true
        System.out.println(clone.equals(pn)); // true가 아닐 수도 있다.
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }


}
