package effective.java.item10.ch3;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 일관성은 필드가 불변필드가아니면 깨질수가있다.
 * 그러나 불변필드라면 일관성은 깨져서는 안된다.
 */
public class EqualsInJava {
    public static void main(String[] args) throws MalformedURLException {
        //일관성 위배 가능성이 있다.
        URL url1 = new URL("https", "about.google", "/products/");
        URL url2 = new URL("https", "about.google", "/products/");
        System.out.println(url1.equals(url2));

        //host가 변할수있어서 일관성이 깨질수있다.
        //근데 그냥 domain이 about.google이면 같다고하자 VM을 쓰면 안에 내부아이피가 달라져서 일관성이 깨질수있다.
        //일관성을 보장하기위해서면, 너무 값을 깊게까지 들어가서 비교하지말자. (여러가지 전부다 비교하지마세요란 말이 아닌듯)
        //일단 요정도만 알고있자

        //equals에 당연히 null을 넘기면 false가 나와야한다.


    }

}
