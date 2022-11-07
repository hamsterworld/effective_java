package effective.java.item1.staticfactory.BadPoint2;

/**
 * 이생성자는 newInstance()를 통해서 만든다.
 */
public class Settings {

    private boolean userAutoSteer;
    private boolean useABS;
    private Difficulty difficulty;

    public Settings(){

    }

    public Settings(boolean userAutoSteer, boolean useABS, Difficulty difficulty) {
        this.userAutoSteer = userAutoSteer;
        this.useABS = useABS;
        this.difficulty = difficulty;
    }

    private static final Settings SETTINGS = new Settings();
    public static Settings newInstance(){
        return SETTINGS;
    }

    /**j
     * javadoc문서에서 아애는 생성자로 만드는게아니라
     * 바로 newInstance로 얻는구나 등등을 주석으로 알아야한다.
     * */


}
