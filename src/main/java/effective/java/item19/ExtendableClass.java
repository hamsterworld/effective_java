package effective.java.item19;

/**
 * 좋은 API 란 어떻게 가 아니라 무엇을 하는 지 설명하는 API 다.
 *
 * 만약에 내가 서울로 간다라는 API 가있으면 서울로 가면 가는거지
 * 몇번버스를 타고 몇번 전철을 타서 몇시간을 가고 어디서내려서 서울을 간다 이런게 아니다.
 * 그러면 결국 우리는 내부구현에 묶이게된다.
 *
 * 그러나, 상속을 허용하는 method 에서는 굉장히 구체적으로 무엇을 하는지 기술 하는것이다.
 * 어떤식으로 동작하는지 왜냐면 해당 class 를 상속받아서
 * 재정의 하는 매서드가 그것을 알아야하기때문이다.
 * 즉, 애초에 캡슐화가 깨져버리기때문이다.
 *
 * 전에도 봤듯이 addAll 이 어떻게 구현되었는지 모르고 count 를 증가시켰더니
 * sideEffect 가 나타났다. 그래서 우리는 내부구현을 자세히 알고있어야한다.
 * @implSpec 을 통해서 내부 구현이나 동작원리에대해서 설명해주고있다.
 * javadoc 은 implSpec 을 몰라서 추가명령어를 해줘야된다.
 */
public class ExtendableClass {

    /**
     * this method can be overridden to print any message
     *
     * @implSpec
     * please use System.out.println()
     */
    public void doSomething(){
        System.out.println("hello");
    }

    // 다른사람이 직접 구현해보도록 시켜서
    // 내 의도대로 잘만드는지 확인해보는것도 좋다.
    protected void doSomething1(){
        System.out.println("hello");
    }
}
