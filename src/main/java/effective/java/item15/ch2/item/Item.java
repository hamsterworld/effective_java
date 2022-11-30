package effective.java.item15.ch2.item;

import effective.java.item15.ch2.member.MemberService;

/**
 * 구현체가 뭐든 넌 관심가지지말고
 * memberService 만 알면된다.
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
