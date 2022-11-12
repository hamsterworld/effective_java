package effective.java.item8.ch1.cleaner_as_a_safetynet;

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
