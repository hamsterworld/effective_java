package effective.java.item15.ch3;

import effective.java.item15.ch2.member.MemberService;
/**
 * 기본적인 필드들은 private 로만들고
 * 필요하면 package-private 정도로 풀어준다.
 * package-private 가 너무많아지면 component 를 나눠야하는건 아닌지 고민해볼것.
 */
public class ItemService {
//    private MemberService memberService;

    MemberService memberService;

    boolean onSale;

    // 위에는 정보 은닉 private 과 package-private 는 내부구현
    // --------------------------------------------------
    protected int saleRate;
    //만약에 itemService 를 누군가 상속한다면
    //protected 를 사용할수잇다는것 사용범위가 굉장히 넓어진다. 물론 final class 로 막을수있다.

    public ItemService(MemberService memberService) {
        if (memberService == null){
            throw new IllegalArgumentException("memberService 를 넘기지마세요.");
        }
        this.memberService = memberService;
    }

// 위에는 공개하는것들
    // 외부 Client 가 사용해야한다면 public 으로 매서드로 노출하는것이 좋다 필드를 public 으로 하는것은 권장하지않는다.
    // public 클래스에 있는 인스턴스필드는 되도록 public 이면 안된다!(item16)
}
