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
 *  ------------------------------------------------------------
 *  만약에 MemberRepository 는 package-private 이고 여기서만 사용된다면?
 */
class DefaultMemberService implements MemberService {

    MemberRepository memberRepository = new MemberRepository();

    private String name;

    @Override
    public String hello() {
        return "내가 무슨 구현체인지 알필요가 넌없다.";
    }

    public String getMember(){
        return memberRepository.findById();
    }

    // 어차피 여기서만 쓰고 같이 package-private 니까.
    // 이렇게 중첩시키자라는말
    // 또 static 은 서로를 참조하지않는다.
    // static 은 사실상 거이 남남이다.
    // 원래 이 중첩시킨 class 가 밖에 있던것을 생각하면. 오히려 private 'static' 이 더 직관적이다.
    private static class MemberRepository{
        String findById(){
//            System.out.println(name); // --> 이거 불가능
            return "찾앗당!";
        };
    }

    //static 아닌애들은 아래처럼 service 의 필드를 가져가서 사용할수있다.
    //왜냐 참조를 알기때문이다.
    //그러나
//    private class MemberRepository{
//        String findById(){
//            return name;
//        };
//    }

    public static void main(String[] args) {
        DefaultMemberService defaultMemberService = new DefaultMemberService();
        defaultMemberService.getMember();
    }
}
