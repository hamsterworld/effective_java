package effective.java.item14.ch3;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * 이제 우리가 comparable interface 를 구현해보자.
 */
public class PhoneNumber implements Comparable<PhoneNumber>{

    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode,999,"area code");
        this.prefix = rangeCheck(prefix,999,"prefix");
        this.lineNum = rangeCheck(lineNum,9999,"line num");
    }

    private static short rangeCheck(int val,int max,String arg){
        if(val < 0 || val > max){
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PhoneNumber that = (PhoneNumber) o;

        if (areaCode != that.areaCode)
            return false;
        if (prefix != that.prefix)
            return false;
        return lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNum;
        return result;
    }


//    @Override
//    public int compareTo(@NotNull PhoneNumber o) {
//        int result = Integer.compare(areaCode, o.areaCode);
//        if(result == 0){
//            result = Integer.compare(prefix,o.prefix);
//            if(result ==0){
//                result = Integer.compare(lineNum,o.lineNum);
//            }
//        }
//        return result;
//    }

    /**
     * java 8부터는 Comparator 가 제공하는 static method 를 사용해서
     * Comparator 를 구현해낼수있다.
     */
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt(PhoneNumber::getAreaCode)
                    .thenComparing((pn) -> pn.prefix)
                    .thenComparing((pn) -> pn.lineNum,((o1, o2) -> o1.intValue()));
    private static final Comparator<PhoneNumber> COMPARATOR1 =
            Comparator.comparing(PhoneNumber::getAreaCode,((o1, o2) -> o1.intValue()));
    //위에서 comparing 으로 시작을 한다.
    //그리고 Comparator 라는 인스턴스를 반환한다.
    //그다음부터는 Comparator 가들고있는 method 를 method chaning 통해 그다음은 이거비교하고 그다음은이거비교하고
    //체이닝을 할수있다.

    //위에처럼 쓴다면 안에 구현된 기본적인 natural order를 사용하겠다라는거고
    //만약에 다른 order를 넣고싶다면 따로 넣어줘야한다.

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNum() {
        return lineNum;
    }

    @Override
    public int compareTo(@NotNull PhoneNumber o) {
        return COMPARATOR.compare(this,o);
    }
}
