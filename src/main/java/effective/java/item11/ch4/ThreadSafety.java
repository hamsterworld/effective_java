package effective.java.item11.ch4;

public class ThreadSafety {
    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public ThreadSafety(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private int hashCode; //자동으로 0으로 초기화한다.

    @Override
    public int hashCode(){
        //T1 , T2여기 들어온다하더라도 hashcode라는 공유데이터때메 뭔가 위험할것같다. 근데 이코드는 안전해보인다. --> 안전한 이유를 말해보라.
        int result = hashCode;
        if(hashCode == 0){
            //T1, T2가 동시에 들어올수있다.
            result = Integer.hashCode(areaCode);
            result = 31 * result + Integer.hashCode(prefix);
            result = 31 * result + Integer.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    // synchronized method를 걸면 성능에 문제가 생기므로

    // double checking locking을 걸어서 synchronized를 최소화한다.


    // 참고로 불변객체도 thread-safety 하다.
    // set 도 없고 final 이므로 변경의 여지가없다.

    // HashTable 은 threadsafe 하다.

    // concurrent 를 지원한다 값을 읽는것은 동시에 여러쓰레드가 접근하는것을 허용한다.
    // 동시성을 보장한다. 이부분은 나중에 다시 공부해보자.

}
