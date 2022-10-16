package effective.java.item1.ExpandableApplication.bridgepattern;

public class test {

    public static void main(String[] args) {
        Tiger tiger = new Tiger(new Hunting_Method2());
        Bird bird = new Bird(new Hunting_Method1());

        tiger.hunt();
        bird.hunt();

    }
}
