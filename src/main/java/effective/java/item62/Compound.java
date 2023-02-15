package effective.java.item62;

/**
 * (기본값타입 = int,String,long...)
 *  다른타입이 적당하다면 문자열 사용을 피해라.
 *  1. 문자열은 다른값타입을 대신하기에는 적합하지않다.
 *    - 받은 데이터가 수치라면 int,float,BigInteger...등 수치타입으로 변환해야한다.
 *    - 예/아니요 질문의 답이라면 적절한 열거타입이나, boolean 으로 변환해야한다.
 *    - 기본타입이든 참조타입이든 적절한 타입이 있다면 그것을 사용하고 없다면 새로작성하라.
 *
 *  2. 문자열은 열거타입을 대신하기에 적합하지않다. (item34)
 *
 *  3. 문자열은 혼합타입을 대신하기에 적합하지않다.
 *     - (아래 예시 참조)
 */
public class Compound {
    private String compoundKey;

    // 서로 다른타입을 혼합해서쓴다? => 좋지않은예이다.
    // 또 두요소를 구분하기위해서 # 쓴다?
    // 파싱해야되서 느리고,귀찮고,오류가능성도 커진다.
    // equals,toString,compareTo 도 사용못한다. 오직 String 이 제공하는 기능만 사용해야한다.
    // 차라리 전용 클래스르 만들자 => item24 private static class
    public void setCompoundKey(String className,int index){
        this.compoundKey = className + "#" + index;
    }

    private static class compoundKey{
        private String className;
        private int index;

        public compoundKey(String className, int index) {
            this.className = className;
            this.index = index;
        }
    }

}
