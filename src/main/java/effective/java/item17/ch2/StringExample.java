package effective.java.item17.ch2;

/**
 * 가변 동반 class 를 제공하라.
 * (새로운 객체를 너무 많이 만들어버리는 경우에..)
 */
public class StringExample {

    public static void main(String[] args) {
        String name ="whiteShip";
        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.append("KeeSun");
        System.out.println(nameBuilder);
    }

}
