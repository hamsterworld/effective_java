package effective.java.item17.ch1;

/**
 * 상속이 불변을 깨뜨릴 여지가있다.
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
