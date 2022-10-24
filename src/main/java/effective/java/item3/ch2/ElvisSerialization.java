package effective.java.item3.ch2;

import java.io.*;

//역직렬화로 여러 인스턴스 만들기
//직렬화를 통해서 객체정보를 저장할수있다.
//역직렬화로 어딘가에 저장되어있는 정보를 읽어올수가있다.
public class ElvisSerialization {

    //참고로할때 Elvis에서 implements에 Serializable를 해줘야된다.
    public static void main(String[] args) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))){
            out.writeObject(Elvis.Instance);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("elvis.obj"))){
            Elvis elvis = (Elvis) in.readObject();
            System.out.println(elvis == Elvis.Instance);
            //false가 뜬다 역직렬화로 통해 새롭게 instance가 생긴것이다.
            //그래서 다시 readResolve() 를 오버라이딩해서 <실제로근데 오버라이딩이아니지만 일단은 이매서드(readResovle)를 써서
            // 역직렬화할때 기존의 Instance를 내게된다면 true가 된다.>
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //결국에는 싱글톤을 쓰려면
    //1.created를 해서 생성자에서 리플렉서를 막아준다.
    //2.readResolve를해서 기존 instance를 하는것을 방지한다.
    //(readResolve햇을땐 create랑 해도된다.)
    //근데 이렇게하면 결국 복잡해진다. 간결하지가않다.
    //물론 스프링을쓰면 ioc container가 singleton pattern을 보장해주기때문에.
    //이는 스프링을 쓰지않을때 이야기라고 생각하면 편하다.

}
