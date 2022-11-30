package effective.java.item15.ch2.member;

/**
 *  이것은 public 으로? 아니면 private 가 나을까?
 *  이 구현체는 요 구현체 안에서만 알면됫지.
 *  밖에서 얘가 special 인지 default 인지 fucking 인지
 *  알필요가있나?
 *
 *  그냥 item Component 나 다른 Component 들은
 *  이 MemberService 가지고 코딩하기를 바란다.
 *
 *  그럼 item 에서는 어떤 구현체를 가져다가 써야되냐?
 *  그것은 item 이 알필요없고
 *  member 라는 module,Component 에서 MemberService 를 쓰면될것같다.
 *
 */
class DefaultMemberService implements MemberService {

    @Override
    public String hello() {
        return "내가 무슨 구현체인지 알필요가 넌없다.";
    }
}
