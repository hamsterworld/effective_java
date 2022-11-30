package effective.java.item3.ch1;


public class Concert2 {

    private boolean lightsOn;

    private boolean mainStateOpen;

    private IElvis elvis;

    public Concert2(IElvis ielvis){
        this.elvis = ielvis;
    }

    public void perform(){
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn(){
        return lightsOn;
    }

    public boolean isMainStateOpen(){
        return mainStateOpen;
    }

}
