package effective.java.item31.ch2.exmaple;

// 한번 wrapper 하는 class 이다.
// Comparable 은 자기 자신을 구현 하는데...
// 근데 그 구현된 Box<T> 에서 T 가
// Comparable 을 구현한 T여야 한다는 것이다.
public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    protected T value;

    public Box(T value) {
        this.value = value;
    }

    public void change(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Box anotherBox) {
        return this.value.compareTo((T)anotherBox.value);
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }
}
