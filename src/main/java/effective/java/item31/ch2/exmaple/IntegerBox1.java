package effective.java.item31.ch2.exmaple;

public class IntegerBox1 extends Box<Integer> {

    private final String message;

    public IntegerBox1(int value, String message) {
        super(value);
        this.message = message;
    }

    @Override
    public String toString() {
        return "IntegerBox{" +
                "message='" + message + '\'' +
                ", value=" + value +
                '}';
    }
    @Override
    public int compareTo(Box anotherBox) {
        return -super.compareTo(anotherBox);
    }
}
