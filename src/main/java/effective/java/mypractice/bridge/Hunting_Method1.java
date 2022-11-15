package effective.java.mypractice.bridge;

import effective.java.mypractice.bridge.Hunting_Handler;

public class Hunting_Method1 implements Hunting_Handler {


    @Override
    public void Find_Quarry() {
        System.out.println("물 위에서 찾는다.");
    }

    @Override
    public void Detected_Quarry() {
        System.out.println("물고기 발견");
    }

    @Override
    public void attack() {
        System.out.println("낚아챈다.");
    }
}
