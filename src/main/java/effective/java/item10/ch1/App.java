package effective.java.item10.ch1;

/**
 * private class에대해서 잠깐 알아봄
 */
public class App {
    public static void main(String[] args) {

        equals e = new equals();
        equals.Hamster hamster = e.new Hamster();
        equals.staticHamster staticHamster = new equals.staticHamster("햄스터");

    }
}
