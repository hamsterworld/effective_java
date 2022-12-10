package effective.java.item15.ch2.member;

/**
 * top-level 에는 오직 2가지이다.
 * package-public private 둘중하나이다.
 *
 * package-public 이 되면 다른 package 에서도 사용할수있다
 * 그러나
 * private 가된다면 다른 package 에서는 사용할수없다.
 *
 * 일단 public 이 된다면 내가 평생유지해야할 class 가되는것이다.
 *
 */
//public class MemberService {
//
//
//}

/**
 * interface 에는 public 이 나을까 private 가 나을까?
 * 물론 memberService 에 따라 달라질것이다.
 *
 * public 이 나을지도?
 *
 * item component 가 MemberService interface 를 사용해가지고
 * item 을 조회해가는것을 생각해본다면 public 이 낫다.
 */
public interface MemberService {

    String hello();


}