package effective.java.item8.ch1.cleaner_as_a_safetynet;

/**
 * 안전망이 라는게 바로 이런거다
 * 사용하는 쪽에서 try-with-resource 를 사용안할수도있다.
 * 그러므로, cleaner 를 등록해서 Client 쪽에서 사용안할시
 * GC 될때 cleaner 가 호출될 수도 있다는것.
 */
public class Teenager {
    public static void main(String[] args) {
        //얘는 걍 room 만들고 끝내버린다.
        new Room(99);
        System.out.println("Peace Out");

        //다음줄의 주석을 해체한후 다시확인해보자.
        //단, 가비지 컬렉터를 강제로 호출하는 이런 방식에 의존해서는 절대 안된다.
        System.gc();
    }
}
