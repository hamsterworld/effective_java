package effective.java.item1.staticfactory.GoodPoint2;

public class Settings {

    private boolean userAutoSteer;
    private boolean useABS;
    private Difficulty difficulty;

    /**
     * 아래처럼 만들면 외부에서 생성자를 생성못한다.
     * */
    private Settings(){

    }

    /**
     * 요로코롬 미리만들어서 인스턴스생성을 제어할수도있다.
     * */
    private static final Settings SETTINGS = new Settings();
    public static Settings newInstance(){
        return SETTINGS;
    }


    /**
     *  생성자를 public 하게 제공하는 순간부터,
     *  사용하는쪽에서 마음껏 생성할수가있다.
     *  그래서 정적팩토리 매서드를 사용하면 인스턴스생성을 제어가능함과 동시에
     *  미리 만들어둔 것(인스턴스,상수등등)을 매개변수에 뭐가 들어오냐에따라 다르게 줄수있다.
     *  ex)valueOf
     * */

}
