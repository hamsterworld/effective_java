package effective.java.item8.ch1.AutoCloseable;

import java.io.BufferedInputStream;

public class AutoClosableIsGood implements AutoCloseable{

    private BufferedInputStream inputStream;

    //Override해서 정리할거 정리하고 하면 된다.
    @Override
    public void close() throws Exception {
        try{
            inputStream.close();
        } catch (Exception e){
            e.getMessage();
        }
    }
}
