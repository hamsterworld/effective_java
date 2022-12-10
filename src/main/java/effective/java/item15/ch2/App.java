package effective.java.item15.ch2;

import effective.java.item15.ch1.Member;

/**
 * 이번 챕터는 꼭 지켜야되는 것은 아니다.
 * 그러나 지키면 좀더 객체지향적인 설계가 가능하다.
 *
 * package-private
 * package-public
 *
 * public 으로 선언하면 API 가 되므로
 * 하위 호환성을 유지하려면 영원히 관리해야한다.
 * --> 우리의 프로그램의 버전이 올라가고 그러면
 * 어딘가의 jar 파일에 나의 public api 가 사용될수있다.
 *
 * 그래서 만약에 client code 에서 나의 api를
 * 사용하고 있고 내가만약에 이 api 를
 * 변경하려고나 햇다면 그 client code 들이 전부깨지고
 * 전부 변경해야함으로 public 은 신중해야한다.
 *
 * 하위 호환성을 유지할거냐 안할거냐는
 * 의문이지만 유지하는게 낫긴한데...
 * 너무 하위호환성에 엮여잇으면
 * 새로운것을 시도하지 못할수도있다.
 *
 * 외부에 쓰지않을거면 private 를 해라.
 *
 *
 */
public class App {

    public static void main(String[] args) {
//        MemberService memberService = new MemberService();
    }
}
