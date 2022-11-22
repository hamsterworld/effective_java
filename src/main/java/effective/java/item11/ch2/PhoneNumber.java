package effective.java.item11.ch2;

import effective.java.item10.ch7.Point;

import java.util.Arrays;

/**
 * hashcode 를 재정의 하는 방법
 */
public class PhoneNumber {

    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    private Point point;

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

//    @Override
//    public int hashCode() {
//        //primitive type을 hashcode로 만들때
//        int result = Integer.hashCode(areaCode);
//        result = 31 * result + Integer.hashCode(prefix);
//        result = 31 * result + Integer.hashCode(lineNum);
//
//        //reference type을 hashcode로 만들때
//        int i = point.hashCode(); //이렇게 호출해서 값을 구한다.
//
//        //Collections를 hashcode로 만들때는
////        int i1 = Arrays.hashCode();
//        return result;
//    }
    // 위와같은 방법이 전형적인 hashcode를 구하는 방법이다.
    // 왜 31이냐?
    // 일단 홀수를 써야한다.
    // 홀수중 왜 31이냐?
    // 연구결과로 collision이 제일 적엇던게 31이다.
    // hashcode의 핵심은 골고루 만드는것이다.

    //사실 이대로만 써도 충분하긴하다.

    // 해시코드를 지연 초기화하는 hashcode 매서드
    // 미리 생성자에서 계산하는것이아니라 0으로 지연 초기화 해놓고,
    // 필요하면
    private int hashCode; //자동으로 0으로 초기화
    //캐싱도 된다. but 스레드 안전성을 신경써야한다.
    //즉, 이 hashCode 안에 thread가 2개가 들어가서 막계산하다가 변경될수도있다.

    @Override
    public int hashCode(){
        int result = hashCode;
        if(hashCode == 0){
            result = Integer.hashCode(areaCode);
            result = 31 * result + Integer.hashCode(prefix);
            result = 31 * result + Integer.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    //계산할때 equals에 쓰는 필드빼지마라.

}
