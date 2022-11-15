package effective.java.item1.ExpandableApplication.bridgepattern;

public class test {

    public static void main(String[] args) {
        Animal tiger = new Tiger(new Hunting_Method2());
        Animal bird = new Bird(new Hunting_Method1());

        tiger.hunt();
        bird.hunt();

    }
}
