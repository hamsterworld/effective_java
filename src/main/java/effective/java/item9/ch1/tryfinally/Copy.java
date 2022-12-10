package effective.java.item9.ch1.tryfinally;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    // 자원이 둘 이상이면 try-finally 방식은 너무 지저분해진다.
    //그러면 그럴수있다 어? 그냥 try{} 하나만쓰고
    //finally{ out.close() in.close() 다하면되지않아?
    //그러면 중간에 에러가나면 리소스들이 제대로 안닫힐수도있다 leak 이 일어난다.
    //만약에 out 에서 문제가생겨서 안닫히더라도 최소한 in은 닫을수있다 아래처럼 try 를 2개쓰면.
    //물론 이코드도 문제는 없지만 좀더 권장하는 방법이 있다.
    static void copy(String src,String dst) throws IOException {
        FileInputStream in = new FileInputStream(src);
        try{
            FileOutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0){
                    out.write(buf,0,n);
                }
            } finally{
                out.close();
            }
        } finally{
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src,dst);
    }

}
