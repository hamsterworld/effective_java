package effective.java.item11.ch1.hashcode;

/**
 * equals 를 재정의하면 왜 hashcode 를 재정의 해야할까?
 * 1. equals 비교에 사용되는 정보가 변경되지 않았다면 hashcode 는 매번 같은 값을 리턴해야 한다.
 * 2. 두 객체에 대한 equals 가 같다면, hashcode 의 값도 같아야 한다.
 * 3. 두 객체에 대한 equals 가 다르더라도, hashcode 의 값은 같을 수 있지만 해시테이블 성능을 고려해 다른값을 리턴하는 것이 좋다.
 *
 * hashcode 를 구현할때 제약사항은?
 * 1. equals 구현할때 썻던 field 들을 모두 사용해야한다.
 * 2. equals 가 같다면 왜 hashcode 도 같아야하는가?
 */
public class PhoneNumber {

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

        // 와 이것까지 잡아주네.
//        Class<?> aClass1 = o.getClass();
        //아래는 자동완성안되는이유 보장이 안된다.
//        int lineNum1 = ((PhoneNumber) o).lineNum;
        if (this == o)
            return true;

        Class<? extends PhoneNumber> aClass1 = getClass();
        Class<?> aClass2 = o.getClass();


        if (o == null || getClass() != o.getClass())
            return false;
        Class<?> aClass = o.getClass();
        //아래는 어느정도 보장이 된다.
//        int lineNum1 = ((PhoneNumber) o).lineNum;
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
        result = 31 * result + prefix;
        result = 31 * result + lineNum;
        return result;
    }

//    @Override
//    public int hashCode() {
//        return 1;
//    }

}
