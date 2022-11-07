package effective.java.item5.ch2;

import effective.java.item5.ch2.Dictionary;

import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary){
        this.dictionary = dictionary;
    }
    //만약에 자원으로 사용되는 인스턴스가 만드는데 복잡하거나 그렇다면
    //factory를 사용하는것도 좋다
    //또 java8의 Supplier는 가장완벽한 factory의 대체제이다.
    //Supplier T get(); --> arg는없고 새로운것을 return하는 놈.
    public SpellChecker(DictionaryFactory dictionaryFactory){
        //밑에 factory로 보면 결국에는 arg를 넣지않고 무엇가만 return하는것이라면
        //factory도 만들필요도 없다.
        //그래서 바꿔보자.
        this.dictionary = dictionaryFactory.get();
    }
    //이것이바로 supplier에 완벽한 factory의 대체제가 될수있다.
    //또 책에서는 와일드카드까지 사용해서 타입매개변수도 제한하라라고한다.
    //근데 사실 Dictionary가 구현체나 하위타입들은 모두 가능하므로 굳이 크게 상관은 없는거같다.
    public SpellChecker(Supplier<Dictionary> dictionarySupplier){
        this.dictionary = dictionarySupplier.get();
    }


    public void isValid(String test) {
        dictionary.contains(test);
    }
}
