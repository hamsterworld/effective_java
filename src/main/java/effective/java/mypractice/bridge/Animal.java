package effective.java.mypractice.bridge;

public abstract class Animal {

    private Hunting_Handler hunting;

    protected Animal(Hunting_Handler hunting_handler) {
        this.hunting = hunting_handler;
    }

    public void Find_Quarry() {
        hunting.Find_Quarry();
    }

    public void Detected_Quarry() {
        hunting.Detected_Quarry();
    }

    public void attack() {
        hunting.attack();
    }

    public void hunt() {
        Find_Quarry();
        Detected_Quarry();
        attack();
    }

}
