package effective.java.item58;

import java.util.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    // 버그를 찾아보자.
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        /**
         * 버그의 원인은 뭘까?
         *
         */
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(i.next(), j.next())); // suit 하나당 한번씩불려야되는데 여러번 불려지고있다. NoSuchElementException

        // 굳이 고친다면?
        // 그러나 이쁘지않다.
        for(Iterator<Suit> i = suits.iterator(); i.hasNext();){
            Suit suit = i.next();
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                deck.add(new Card(suit,j.next()));
            }
        }

        /**
         * 버그를 못찾는다고해서 슬퍼하지말자. 아래처럼 사용하자!
         * 우리는 for-each 와 친해져야한다.
         */
//        // 코드 58-7 컬렉션이나 배열의 중첩 반복을 위한 권장 관용구 (349쪽)
//        for (Suit suit : suits)
//            for (Rank rank : ranks)
//                deck.add(new Card(suit, rank));
    }
}
