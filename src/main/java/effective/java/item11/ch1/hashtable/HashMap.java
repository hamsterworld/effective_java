package effective.java.item11.ch1.hashtable;

import effective.java.item11.ch1.hashcode.PhoneNumber;

import java.util.HashSet;
import java.util.Map;

public class HashMap {
    public static void main(String[] args) {

        Map<PhoneNumber, String> map = new java.util.HashMap<>();

        PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
//        PhoneNumber number2 = new PhoneNumber(123, 456, 7890);
        PhoneNumber number2 = new PhoneNumber(343, 555, 8888); //같은 hashcode 를 강제로 설정해서 준다면 무슨일이 벌어질까


        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());
        //equals 는 같지만 hashcode 는 다르게 나온다.

        map.put(number1,"inseok");
        map.put(number2,"whiteship");

        String s = map.get(number2);
        System.out.println(s);

        // equals 가 같다면 hashcode 도 같아야한다는데 별문제가 없는것같다.
        // phoneNumber 는 value class 이므로 같은 값이 들어가면 같다고 동작해야한다.


//        String s1 = map.get(new PhoneNumber(123, 456, 7890));
//        System.out.println(s1);

        // 위에에서 문제가발생한다 null 이 나온다.
        // hashcode 가 달라서 null 이 나온다.

        // 이래도 잘 동작한다.
        // 근데 굳이 왜 hashcode 재설정해야하나?
        // hash collision 이 발생한다.
        // hashmap 을 쓰는 장점이 싹다 사라진다.
        // o(1) -> o(n) 으로 변경된다. HashMap 의 장점이 사라진다. (index 번호로 뽑아오기때문에 사실상 o(1)임)
        // hashcode 는 같으니까 그 LinkedList 에서 같은 equals 를 비교해버린다. 그리고 값을 꺼낸다.
        // 그냥 linkedList 를 쓰는것과 동일하게된다..

    }

    /**
     * 다음 경우의 수를 모두 설명할수있으면 합격
     *
     * 1. equals 같고 hashcode 같은경우
     * 2. equals 같고 hashcode 다른경우
     * 3. equals 다르고 hashcode 같은경우
     */

}
