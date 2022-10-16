package effective.java.item1.Flyweight;

public class Character {
    //자주 바뀌지않는다.
    private char value;
    private String color;
    //자주 바뀜
//    private String fontFamily;
//    private int fontSize;
    //---> Font로 묶는다 이것만으로는 개선x
    private Font font;

    public Character(char value, String color, String fontFamily, int fontSize) {
        this.value = value;
        this.color = color;
//        this.fontFamily = fontFamily;
//        this.fontSize = fontSize;
    }

    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
