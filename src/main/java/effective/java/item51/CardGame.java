package effective.java.item51;

// 매개변수를 하나로 주고받는 helper class
public class CardGame {

    // 대충 게임 start 하는 매서드가 있다고 해보자.
    // 시작할때 rank(숫자) 와 suit(무늬)를 매개변수로 받는다고 해보자
    public void gameStart(int rank,String suit){
        // 어쩌구
        // ...
        // 저쩌구 로직
    }

    // 아래가 훨씬 깔끔하며 가독성도 좋다.
    public void gameStart(Card card){
        // 어쩌구
        // ...
        // 저쩌구 로직
    }

}
