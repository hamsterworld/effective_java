package effective.java.item5.ch1;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * item5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 *
 * 1. 사용하는 자원에 따라 동작이 달라지는 클래스는 정적 유틸리티 클래스나 싱글턴방식이 적합하지않다.
 *                                    (이것만 봐도 instance 로 넘겨주고 하기때메 static 은 적합x)
 *                                    --> 다시말하면 자원에따라 동작이 달라지는 클래스로는
 *                                    정적유틸리티클래스(instance 생성을 막는 놈들)나 싱글톤방식으로 만들면안되는것인가?
 * 2. 의존객체주입이란 인스턴스를 생성할때 필요한 자원을 넘겨주는 방식이다.
 * 3. 이 방식의 변형으로 생성자에 자원팩터리를 넘겨줄수있다.
 * 4. 의존객체주입을 사용하면 클래스의 유연성,재사용성,테스트 용이성을 개선할수있다.
 *
 * 의존객체 주입이란? 인스턴스를 생성할때 필요한 자원을 넘겨주는 방식이다.
 *
 */
public class SpellChecker {

    //이 Dictionary 라는 사전은 바뀔수있다. 영어사전이냐,독일어사전이냐,한국어사전이냐 등등..
    //그래서 코드가 아래와같을때 내가 영어사전 -> 독일어사전으로 변경하고 싶을때 어떻게해야되냐?
    private static final Dictionary dictionary = new Dictionary();
    //위와같은 코드가 자원을 직접명시한다는 말이다. new Dictionary
    //즉 new 로 직접 객체를 생성하지말라는 말이다.
    //어떤경우에? 내가 가진 자원에따라 동작이 달라지는 경우에.

    private SpellChecker(){

    }

    /**
     * 이렇게 유연하게 의존객체주입을 받아야한다.
     * --> item51.txt code 로 가보자.
     */
    private Dictionary DICTIONARY1;

    public SpellChecker(Dictionary dictionary){
        this.DICTIONARY1 = dictionary;
    }


    public static boolean isValid(String word){
        //Spellchecker 만에 특별한 코드가있다고 가정
        //만약에 달랑 이렇게있으면 그냥 dictionary 의 wrapper class 밖에 안된다.
        //그리고 Spellchecker 만에 코드들을 확인해보고싶다. 즉, 테스트해보고싶다.
        //근데 그렇게 못한다 dictionary 를 바꿔넣을수없기때문이다.
        //그리고 dictionary 를 사용하는데 비용도 굉장히 많이든다면?
        //Test 할때마다 굉장히 비효율적이다.
        //그래서 dictionary 를 mocking 하고싶다.

        //또 싱글톤으로 생성하면 유연성과 재사용성이떨어진다.
        //만약에 dictionary 가 영어사전인데
        //한국어사전으로 support 하고싶으면 이 class 는 그냥못씀
        //KoreanSpellcheck 해서 new koreanDictionary 해서 새로만들거냐?
        //유연하지못하고 재사용성도 떨어지게된다.

        //그래서 의존객체주입을해주자 --> 우리가 흔히아는 @Autowired 이런거.
        //그러면 재사용도 가능해진다.
        //대신 dictionary 가 interface 이여야한다.
        return dictionary.contains(word);
    }

    public boolean isValid1(String word){
        //SpellCheckcode
        return DICTIONARY1.contains(word);
    }

    public static List<String> suggestions(String type){
        //Spellchecker 만에 특별한 코드가있다고 가정..
        //..
        //..
        //..
        //..
        //만약에 달랑 이렇게있으면 그냥 dictionary 의 wrapper class 밖에 안된다.
        return dictionary.closeWordsTo(type);
    }



}
