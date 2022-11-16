package effective.java.item10.ch2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CaseInsensitiveStringTest {

    @Test
    void test(){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish"); //대문자
        CaseInsensitiveString cis2 = new CaseInsensitiveString("Polish");
        String polish = "polish"; //소문자

        System.out.println(cis.equals(polish)); //내가정의한 equals때문에 같다고나온다.

        ArrayList<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(polish));
        System.out.println(list.contains(cis2));
        //이렇게 했을때 그러면 list에는 소문자 "polish"가 들어있다고 나와야할것이다.
        //근데 그렇게 나오지않는다. false가 뜬다.
        //contains에 들어가는 arg의 equals를 가져다 쓴다.

        //좀더극단적으로.
        //String은 CaseInsensitiveString를 모른다.
        System.out.println(polish.equals(cis));
    }

    @Test
    void test2(){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish"); //대문자
        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");

        System.out.println(cis.equals(cis2));
        System.out.println(cis2.equals(cis));
    }


}