package effective.java.item8.ch1.AutoCloseable;

public class app {
    public static void main(String[] args) throws Exception {

        /**
         * 원래보통은 try , catch 하고 finally 에서 자원을 정리했엇다.
         * 이렇게 안하고 아래처럼 권장한다.
         */
//        try{
//
//        } catch (){
//
//        } finally {
//
//        }

        /**
         * 한번이라도 삭제할수있는 기회라도 준다.
         * 사실상 cleaner 를 사용하는것은 안전망이다.
         * 한번더 삭제할수있는 기회.
         */
        try(AutoClosableIsGood good = new AutoClosableIsGood()){
            //자원 반납처리된다.
        }
    }
}
