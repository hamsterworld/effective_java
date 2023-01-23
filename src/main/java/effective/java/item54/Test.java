package effective.java.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    private final List<String> list = new ArrayList<>();

    // 아래 같은 코드를 작성한다면
    // 클라이언트에서는 추가적인 코드를 작성해야한다.
    public List<String> getStringList(){
        return list.isEmpty() ? null : new ArrayList<>(list);
    }

    // Client 입장에서 null 이 올수도 있다는 매서드를 사용한다면
    // 아래처럼 null 을 처리해주는것이 무조건적으로 필요하다.
    // 실제로 객체가 0개일 가능성이 거의 없는 상황에서는 수년뒤에야 오류가 발생하기도 한다.
    // 결론은 null 을 반환하려면 반환하는 쪽에서도 이상황을 특별히 취급해줘야되서 복잡해진다.
    public static void main(String[] args) {
        Test test = new Test();
        List<String> stringList = test.getStringList();
        if(stringList != null && stringList.contains("내가있니?")){
            System.out.println("있으면 됬다.");
        }
    }

    // null 을 쓰는게 성능문제라고하지만 이는 잘못됬다.
    // 할당은 성능주범이라고 확인되지않는한 신경쓸 수준이 안된다. item 67
    // 빈컬렉션과 배열은 굳이 새로 할당하지않고도 반환할수있다.

    // 아래처럼 빈컬렉션과 배열에대한 올바른 예시
    public List<String> getStringList1(){
        return new ArrayList<>(list);
    }

    // (최적화)그러나 위처럼 사용하면 사용패턴에따라서 빈컬렉션 할당이 성능을 눈에 띄게 떨어뜨리는 경우가있다.

    public List<String> getStringList2(){
        return list.isEmpty() ? Collections.emptyList() : new ArrayList<>(list);
    }



    //또는 길이가 0일수도 있느 배열을 반환하는 올바른 방법
    public String[] getStringList3(){
        return list.toArray(new String[0]);
    }

    // 위 방식이 성능을 떨어뜨릴것 같다면?
    // (최적화)아래처럼 미리 생성해놓고 사용하는 방법도있다.

    private static final String[] EMPTY_CHEESE_ARRAY = new String[0];
    public String[] getStringList4(){
        return list.toArray(EMPTY_CHEESE_ARRAY);
    }

}
