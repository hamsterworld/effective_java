package effective.java.item5.ch2;

import effective.java.item5.ch2.Dictionary;

import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary){
        this.dictionary = dictionary;
    }
    // 만약에 자원으로 사용되는 인스턴스가 만드는데 복잡하거나 그렇다면
    // factory 를 사용하는것도 좋다
    // 또 java8의 Supplier 는 가장 완벽한 factory 의 대체제이다.
    // Supplier T get(); --> arg 는없고 새로운것을 return 하는 놈.
    // 위에처럼 바로 자원을 받지않고 factory 로 한번더 받게된다. 중간과정이 생긴다.
    public SpellChecker(DictionaryFactory dictionaryFactory){
        // 밑에 factory 로 보면 결국에는 arg 를 넣지않고 무엇가만 return 하는것이라면
        // factory 도 만들필요도 없다.
        // 그래서 바꿔보자.
        this.dictionary = dictionaryFactory.get();
        /**
         * 사실 진짜 이게 필요한가 싶기도하다.
         * 만약에 korea 인지 다른사전인지 결정이 이안에서된다면?
         * factory 를 받는 것도 이해가된다.
         */
    }
    // 이것이 바로 supplier 가 완벽한 factory 의 대체제가 될수있다.
    // 또 책에서는 와일드카드까지 사용해서 타입매개변수도 제한하라라고한다.
    // 근데 사실 Dictionary 가 구현체나 하위타입들은 모두 가능하므로 굳이 크게 상관은 없는거같다.
    public SpellChecker(Supplier<Dictionary> dictionarySupplier){
        this.dictionary = dictionarySupplier.get();
        /**
         * 단순히 arg 없이 return 만 하는거라면 supplier 가 충분히 factory method 를 대체할수있다고생각한다.
         */
    }

    /**
     * 나라면 근데 직접자원을 주입받는 방식이 제일 나은것같다.
     * factory 를 이렇게 내부에서 받아서할수있다는점도생각해두면 좋은것같다.
     */

    public void isValid(String test) {
        dictionary.contains(test);
    }
}
