package effective.java.mypractice.bridge;

import effective.java.mypractice.bridge.Animal;
import effective.java.mypractice.bridge.Hunting_Handler;
public class Bird extends Animal {

    public Bird(Hunting_Handler hunting) {
        super(hunting);
    }

    public void hunt() {
        System.out.println("새의 사냥방식");
        Find_Quarry();
        Detected_Quarry();
        attack();
    }

}
