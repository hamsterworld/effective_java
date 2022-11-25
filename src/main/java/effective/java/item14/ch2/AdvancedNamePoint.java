package effective.java.item14.ch2;

import org.jetbrains.annotations.NotNull;

public class AdvancedNamePoint implements Comparable<AdvancedNamePoint>{

    private final Point point;
    private final String name;

    public AdvancedNamePoint(Point point, String name) {
        this.point = point;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull AdvancedNamePoint namePoint) {
        int result = this.point.compareTo(namePoint.point);
        if(result == 0){
            result = this.name.compareTo(name);
        }
        return result;
    }
}
