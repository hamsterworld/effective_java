package effective.java.item1.Flyweight;

public class Client {

    public static void main(String[] args) {
        //FontFactory fontFactory = new FontFactory();
        new Character('h',"white",FontFactory.getFont("nanum:12"));
        new Character('e',"white",FontFactory.getFont("nanum:12"));
        new Character('l',"white",FontFactory.getFont("nanum:12"));
    }

    //getFont를 static으로도 만들수있다.
    //일단 위에처럼하면 nanum:12를 계속객체로 생성하는게아니라,
    //하나의 nanum:12 Font를 계속공유해서 사용하게된다.


}
