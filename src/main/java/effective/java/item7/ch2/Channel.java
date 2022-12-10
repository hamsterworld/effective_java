package effective.java.item7.ch2;

import java.util.Optional;
import java.util.OptionalLong;

/**
 * ChannelTest 에서도 볼수있듯이 NPE를 잡아내기는 if 문으로도 간단히 가능하다.
 * 그래서 우리는 How? NPE 를 덜 만날수있을까가 이번에 핵심이다.
 * Java8 부터지원하는 Optional 기능을 사용한다.
 * Optional 은 return type 으로 쓰라고 만든거지 다른곳에서 쓰라고만든게아니다.
 */
public class Channel {

    private int numberOfSubscribers;

//    public Membership defaultMemberShip(){
//        if(this.numberOfSubscribers < 2000){
//            return null;
//        } else {
//            return new Membership();
//        }
//    }

    public Optional<Membership> defaultMemberShip(){
        if(this.numberOfSubscribers < 2000){
            return Optional.empty();
        } else {
            return Optional.of(new Membership());
        }
    }
    /**
     * 아래와같이 arg로 주는건 의미가없다
     * 왜냐면 결국에는 if로 null 인지아닌지 검사해야하므로 의미가없다.
     * 그리고 파라미터값이 null 을 받을수있기때문이다.
     */
//    public Optional<Membership> defaultMemberShip(Optional<Membership> membership){
//        if(this.numberOfSubscribers < 2000){
//            return Optional.empty();
//        } else {
//            return Optional.of(new Membership());
//        }
//    }

    /**
     * Optional 을 collection 으로 감싸지말것
     * 가령 Optional<List>이런거
     */

    /**
     * 그리고 위에처럼 return type 이 Optional 인데 null 을 넘기지마라.
     * Optional.empty();이렇게 해줘라.
     */

    /**
     * 만약에 기본타입을 감싸야한다면
     * OptionalLong 이런것들이 준비되어있다.
     * ex) OptionalLong optionalLong = OptionalLong.of(10L);
     */

}
