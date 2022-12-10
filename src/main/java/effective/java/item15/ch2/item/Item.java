package effective.java.item15.ch2.item;

import effective.java.item15.ch2.member.MemberService;

/**
 * 구현체가 뭐든 넌 관심가지지말고
 * memberService 만 알면된다.
 * Spring IOC Container 의 도움을 받던지 뭐든지 알아서해라.
 * 제공받는 형식으로 한다면 알필요가없다.
 */
public class Item {

    private final MemberService memberService;

    public Item(MemberService memberService) {
        this.memberService = memberService;
    }

    private void hello(){
        memberService.hello();
    }
}
