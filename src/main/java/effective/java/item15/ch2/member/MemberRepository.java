package effective.java.item15.ch2.member;

/**
 * 만약에 MemberRepository 조차 밖에나갈수없다.
 * 오로지 너는 MemberService 만이 노출되어있다.
 * 즉, 이 인터페이스도 package-private 이다.
 * 근데 만약에 DefaultMemberService 에서만 사용한다면?
 *
 * 그렇다면 그냥 DefaultMemberService 에 중첩시키자.
 */
interface MemberRepository {

    String findById();

}
