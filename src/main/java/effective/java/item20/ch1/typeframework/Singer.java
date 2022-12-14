package effective.java.item20.ch1.typeframework;
/**
 * interface 의 장점으로
 * 계층 구조가 불분명한 type framework 를만들수있다
 *
 * 예를 들어서 사각형 -> 직사각형, 정사각형 .. 등등 이렇게 명확한 계층구조면
 * 사각형 -> 직사각형 -> 마름모 이렇게 상속이 되어있다면 명확한 계층구조를 형성할수있다.
 *
 * 싱어는 싱어고
 * 싱어라이터는 노래만드는 놈들이고
 * 뭔가 서로간의 계층 구조가 힘들다.
 *
 * 또 싱어송라이터도 있을수있다.
 * 노래만드는놈은 노래만드는놈이고
 * 노래부르는놈은 노래부르는놈인데
 * 둘간의 계층구조를 가지기가 힘들다.
 * 이것을 싱어송라이터로 생각하면 뭔가 계층구조가 애매하다.
 *
 * 싱어송라이터를 뭐 노래 만드는 놈 -> 노래 부르는 놈 -> 싱어송라이터
 * 이렇게 해주기도 애매하다.
 *
 * 그래서 싱어송라이터 interface 처럼 만들어 줄수도있다.
 *
 *
 * + 추가적으로 한가지 더 장점 (item 18 참조)
 *  wrapper class 에서 사용하면 interface 는 기능을 향상(확장?)시키는 강력한 수단이 된다.
 * 그래서 wrapper 와 interface 를 사용하는것은 굉장히 안전하게 기능을 확장시킬수있는
 * 수단이 된다.
 *
 */
public interface Singer {
    AudioClip sing(Song song);
}
