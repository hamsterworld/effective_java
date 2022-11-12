package effective.java.item8.ch4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * java 7부터 들어온 autoclose다.
 * autoclean의 장점은 try에다가 사용할수있다는점
 */
public class AutoClosableIsGood implements AutoCloseable{

    private BufferedReader reader;

    public AutoClosableIsGood(String path){
        try{
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path);
        }
    }

    //첫번째 선택 자원반납할때 생기는 Exception을 던질까?
    //던지면 사용하는쪽에서 exception을 catch 해줘야한다.


    @Override
    public void close() throws IOException {
        reader.close();
    }

    //두번째 선택 자원반납할때 안에서 처리한다.
//    @Override
//    public void close()  {
//        try {
//            reader.close();
//        } catch (IOException e) {
//
//        }
//    }

    //세번째 예외변환
    //해당 쓰레드만 죽어버리지 app자체는 죽지않으므로 괜찮다.
    //idempotent여야한다 멱등성이여야한다. 근데 꼭 반드시는 아니다.
    //그래도 권장한다.
//    @Override
//    public void close(){
//        try {
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     * 추가적으로 AutoCloseable를 상속하고있는 closeable이 있는데
     * thorws IOException을 던진다.
     * 그래서 우리가 만드는 리소스를 반환하는 클래스가 i/o와 관련이 있다면?
     * db를 읽거나,소켓을읽거나,파일을읽거나등등
     * closeable를 선택하는것도 좋은 방법일수도있다.
     */

}
