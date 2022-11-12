package effective.java.item8.ch4;

public class App {

    public static void main(String[] args) {
        try(AutoClosableIsGood good = new AutoClosableIsGood("");
            AutoClosableIsGood good1 = new AutoClosableIsGood("")){
            //자원반납처리
            //굳이 finally block을 안 써도된다.
            //여러개도 가능하다.
        } catch (Exception e){

        }
    }
}
