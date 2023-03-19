package effective.java.test;

public class NonAtomicLongExample {
    private static long sharedLong;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedLong = 0xFFFFFFFF00000000L; // 상위 32비트를 1로 설정
                sharedLong = 0x00000000FFFFFFFFL; // 하위 32비트를 1로 설정
            }
        });

        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                long readValue = sharedLong;
                if (readValue != 0xFFFFFFFF00000000L && readValue != 0x00000000FFFFFFFFL) {
                    System.out.println("Inconsistent value: " + Long.toHexString(readValue));
                }
            }
        });

        writerThread.start();
        readerThread.start();

    }
}
