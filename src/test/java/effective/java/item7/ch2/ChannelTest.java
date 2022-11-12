package effective.java.item7.ch2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.util.Optional;


class ChannelTest {

//    @Test
//    void npe(){
//        Channel channel = new Channel();
//        Membership membership = channel.defaultMemberShip();
//        if(membership != null){
//            membership.equals(new Membership());
//        }
//    }

    @Test
    void npe(){
        Channel channel = new Channel();
        Optional<Membership> membership = channel.defaultMemberShip();
        /**
         * Optional은 MemberShip의 hello를 제공해주지않는다.
         * 그래서 Optional의 매서드를 통해 접근해야한다.
         */
        //membership.hello();

        //아래와 같은 방식으로 Optional을 사용할수있다.
        //그래서 Optiional을 사용하면 NPE가 잘안터진다.
        membership.ifPresent(Membership::hello);

        //아래와같은 Optional은 권장하지않는다
        //만약에 null이면 NosuchElementException이 터진다.
        //membership.get();



    }

}