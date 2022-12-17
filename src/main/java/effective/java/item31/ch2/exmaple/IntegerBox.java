package effective.java.item31.ch2.exmaple;

public class IntegerBox extends Box<Integer> {

    private final String message;

    public IntegerBox(int value, String message) {
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
        return super.compareTo(anotherBox);
    }
}
