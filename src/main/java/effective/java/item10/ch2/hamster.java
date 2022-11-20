package effective.java.item10.ch2;

import java.util.Set;

public class hamster {

    private final int i;

    public hamster(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Point)){
            return false;
        }
        hamster p = (hamster) o;
        return p.i == i;
    }

}
