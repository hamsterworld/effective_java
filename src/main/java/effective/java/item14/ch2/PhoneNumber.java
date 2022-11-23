package effective.java.item14.ch2;

import org.jetbrains.annotations.NotNull;

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

    //매서드의 파라미터에서 제네릭타입으로받으니 더이상 이제
    //타입캐스팅을 안해줘도된다.

    //아래 코드를 잠깐 설명하자면 만약에 정렬한다면 뭐를 가장먼저 배열하는지에대한것을 잠깐 엿볼수있다.
    //예를들어서 이름으로 정렬한다고 하면 한국은 성먼저 비교하고 그다음에 이름으로 정렬한다던지..
    @Override
    public int compareTo(@NotNull PhoneNumber o) {
        int result = Integer.compare(areaCode, o.areaCode);
        if(result == 0){
            result = Integer.compare(prefix,o.prefix);
            if(result ==0){
                result = Integer.compare(lineNum,o.lineNum);
            }
        }
        return result;
    }

//    @Override
//    public int hashCode() {
//        return 1;
//    }
}
