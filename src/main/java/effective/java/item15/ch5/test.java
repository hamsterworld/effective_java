package effective.java.item15.ch5;

import effective.java.item15.ch2.member.MemberService;
import effective.java.item15.ch3.ItemService;

public class test extends ItemService {


    public test(MemberService memberService) {
        super(memberService);
    }

    public static void main(String[] args) {
        test test = new test(t);
        int saleRate1 = test.saleRate;

        ItemService itemService = new ItemService();
        itemService.saleRate;
    }
}
