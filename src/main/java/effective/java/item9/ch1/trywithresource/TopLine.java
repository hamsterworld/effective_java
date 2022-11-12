package effective.java.item9.ch1.trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    //아까 try보다는 훨씬더 간결하다.
    //한가지 생소한것은 try block안에서 사용할 자원을 ()안에다가 정의했다는것이다.
    //그리고 close를 직접하지않는다.
    //왜냐면 bufferdReader가 closeable를 구현하고있다.
    //즉, closeable은 autoclosable이기 때문이다.
    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }

}
