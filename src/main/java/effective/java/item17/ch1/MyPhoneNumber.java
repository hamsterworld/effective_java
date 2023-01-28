package effective.java.item17.ch1;

/**
 * 상속이 불변을 깨뜨릴 여지가있다.
 * => 이말인듯
 * 부모 클래스는 불변클래스이지만
 * 자식 클래스는 불변클래스가 아니게된다.
 *
 * 이는 리스코프치환법칙을 위배하는것으로
 * 결론적으로보면 불변이 깨졌다고 생각될수있다.
 */
public class MyPhoneNumber extends PhoneNumber{

    private String name;

    public MyPhoneNumber(short areaCode, short prefix, short lineNum) {
        super(areaCode, prefix, lineNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
