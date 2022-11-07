package effective.java.item3.ch1;


/**
 *   이 Concert라는 인스턴스자체가
 *   Elvis의 clientCode이다.
 *   싱글톤은 이 ClientCode를 test하기 어렵다는 말이다.
 *
 *   근데 이때 elvis가 비싸다고 생각해보자.
 *   무대테스트할때마다 elvis를 부를수는없다.
 *   elvis를 대역으로 쓰고싶어도 elvis를 대역으로 쓸수가없다.
 *   그래서 바로 이말이다.
 *   elvis를 계속호출해서 써야한다는말이다.
 *
 *   밑에 test코드에서 보면알수있듯이
 *   계속 elvis를 호출해서 노래를 부르게된다.
 *   만약에 elvis가 외부 네트워크와 통신하거나
 *   굉장히 무거운 로직을 가진 로직이라면
 *   이는 굉장한 손실이다.
 *
 *   그래서 해결책
 *   만약에 Elvis를 interface로 만들엇다면?
 *   Elvis는 imple인데 싱글톤이고
 *   IElvisimpl은 mock라고 생각해보자.
 *   그러면 IElvisimpl로 가짜 대역을 넣어놓는것이다.
 *
 *   이래서 interface로 만들라는것이다.
 */
public class Concert {

    private boolean lightsOn;

    private boolean mainStateOpen;

    private Elvis elvis;

    public Concert(Elvis elvis){
        this.elvis = elvis;
    }

    public void perform(){
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn(){
        return lightsOn;
    }

    public boolean isMainStateOpen(){
        return mainStateOpen;
    }

}
