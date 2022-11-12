package effective.java.item9.ch1.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineresource {

    /**
     * 여기서는 둘다 보이는것을 확인할수있다.
     * Suppressed로 2번째 오류도 볼수있다.
     * 당연히 원한다면 catch , finally도 사용할수있다.
     * try-with-resource를 쓴다고해서 못쓰는게아니다.
     */
    static String firstLineOfFile(String path) throws IOException {
        try(BadBufferedReader br = new BadBufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "pom.xml";
        System.out.println(firstLineOfFile(path));
    }

}
