package effective.java.item1.staticfactory.BadPoint1;

public class Settings {

    private boolean userAutoSteer;
    private boolean useABS;
    private Difficulty difficulty;

//    private Settings(){
//
//    }


    private static final Settings SETTINGS = new Settings();
    public static Settings newInstance(){
        return SETTINGS;
    }

    /**  private 생성자를 사용하게되면
     *   javadoc에서 문서화가 힘들다.
     *   그래서 주석으로 처리하거나, 명명을 잘해서 해야된다.
     * */


}
