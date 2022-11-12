package effective.java.item9.ch1.suppress;

import java.io.FileReader;
import java.io.IOException;

/**
 * finally가 안좋은이유 Exception을 먹어버린다.
 * 내가 badbuf를 새로 오버라이딩해서
 * readline과 close에서 분명히 exception이 터지는데
 * 누가 나올까?
 * close에서 터진게나온다 맨마지막에 터진것만나온다.
 * 근데 디버깅할때 가장중요한건 가장먼저 터진 exception을 보는게 중요하다.
 * 그래서 finally를 사용하는경우 excpetion이 이렇게 먹히는 경우가 발생할수있다.
 * 물론 안먹히게 할수있고, 그렇게 작성하려면 코드가 지저분해진다.
 *
 * but, autocleaner을 사용하면 아주큰 이점을 얻을수있다.
 */
public class TopLine {

    static String firstLineOfFile(String path) throws IOException{
        BadBufferedReader br = new BadBufferedReader(new FileReader(path));
        try{
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "pom.xml";
        System.out.println(firstLineOfFile(path));
    }

}
