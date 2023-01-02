package effective.java.item35;

/**
 * ordinal 은 절대로 사용하지말것.
 * 쓸일도 없다.
 * 인스턴스 필드를 사용하는것을 권장한다.
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    Ensemble(int size) { this.numberOfMusicians = size; }
    public int numberOfMusicians() { return numberOfMusicians; }

    public static void main(String[] args) {
        int numberOfMusicians1 = Ensemble.DUET.numberOfMusicians;
        System.out.println(numberOfMusicians1);
        System.out.println(Ensemble.DUET.name());
    }
}
