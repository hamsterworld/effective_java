package effective.java.item12;

import java.util.Objects;

/**
 * ToString 을 구현안하면 그냥 hashcode 값을 리턴하니까.
 *
 * 그렇게 유용하지않다 그래서 구현해서 리턴하자라는 말이다~
 *
 * ToString 으로 해서 문자열포멧을 반환하는 경우
 * ToString 에 대한 설명주석이 들어가있는것이 좋다.
 *
 * ToString 은 어쨋든 외부에 정보를 공개하는것이므로,
 * 공개하고싶은 정보만 공개하는게 더낫다고 생각한다.
 *
 * 그리고 ToString 으로 애초에 공개한정보니까
 * 각각의 공개한 정보들에대한 Getter 를 제공하라는 말이다.
 *
 * lombok 이나 자동생성 ToString 의 경우 우리가원하는 문자열포멧이 불가능하다.
 *
 * 결론적으로는 ToString 을 구성하면 of(공개된것만),get(공개된것만)을 구현해주는것을 권장한다.
 */
public class ToString {

    private final int value;
    private final String name;

    public ToString(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static void main(String[] args) {
        ToString t1 = new ToString(1, "hi");
        System.out.println(t1);
        System.out.println(new ToString(2,"hello"));

        ToString of = ToString.of("1,hi");
        System.out.println(ToString.of("1,hi"));
        System.out.println(of.equals(t1));
        System.out.println(t1.equals(of));
        System.out.println(of.equals(new ToString(1,"hi")));

    }

    //이번 ToString에서 나의 포맷은
    //XX,XXX 이라고하자.
    public static ToString of(String valueAndName){
        String[] split = valueAndName.split(",");
        ToString toString = new ToString(Integer.parseInt(split[0]), split[1]);
        return toString;
    }

    @Override
    public String toString() {
        return value+","+name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToString toString = (ToString) o;

        if (value != toString.value) return false;
        return Objects.equals(name, toString.name);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
