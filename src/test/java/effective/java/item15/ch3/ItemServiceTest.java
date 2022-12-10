package effective.java.item15.ch3;

import effective.java.item15.ch2.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //junit5 에서 mockito 를 사용하는 방법.
class ItemServiceTest {

    //지금 나는 ch2 의 defaultMemberService 를 사용하지못한다.
    @Mock
    MemberService memberService;
    //그럼 test 어떻게? => mocking 을 사용한다.
    //대표적인 mocking framework 로는 mockito 가 있다.
    //@Mock 을 통해서 가짜 객체가 전달된다.
    @Test
    void ItemService(){

        ItemService service = new ItemService(memberService);

        assertNotNull(service);
        assertNotNull(service.memberService); // ItemService 에서 memberService 가 private 일때 How? 할것인가
        // 1번방법. getter 를 만들어준다. test 하려는 대상이 이미 getter 를 제공하면 getter 를 써도된다.
        // 2번방법. 차라리 package-private 로 구현한다. test 에서는 같은 package 이다! 맨위에 이름을 잘볼것.
        // 3번방법. getter 를 package-private 로 구현한다. 정말로 뭔가 공개하기싫다면.

        /**
         * 결론 test 를위해 필드들을 public 으로 만들거나 그러지말것.
         * 필드가 public 이 가능할때는 static final 과같은 상수만이 가능하다.(Collection 들은 안된다.)
         */
    }
}