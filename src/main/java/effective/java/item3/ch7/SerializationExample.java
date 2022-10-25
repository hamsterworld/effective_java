package effective.java.item3.ch7;

import effective.java.item3.ch2.Elvis;

import java.io.*;
import java.time.LocalDate;

public class SerializationExample {

    private void serialize(Book book){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.obj"))){
            out.writeObject(book);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private Book deserialize(){
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))){
            return (Book) in.readObject();
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("12345", "이펙티브자바완벽공략", "백기선",
                LocalDate.of(2022, 3, 21));
        book.setNumberOfSold(200);

        Book.name = "in seok"; //직렬화가 되지않는다.

        SerializationExample example = new SerializationExample();
        example.serialize(book);
        Book.name = "whiteShip";
        Book deserializeBook = example.deserialize();

        System.out.println(book);
        System.out.println(deserializeBook);
    }


    //위에 코드를 실행하면 안된다.
    //book에 imple에 serializable을 해주지않아서.


    //또 만약에 Book Object에 numberOfSold를 직렬화하고 싶지 않다..
    //그러면 private transient int numberOfSold; 하면된다.
    //그래서 이것을 붙인곳에는 역직렬화시 0으로 나오는것을 확인할수잇다.

    //public static String name;을 추가해보자.
    //직렬화전 이름을 넣고 직렬화후 이름넣고 역직렬화하면 name은 뭐로나올까?


    //직렬화하고 중간에 class가 변경된상태에서
    //역직렬화하려고하면 역직렬화되지않는다. 그이유는 serializationUID가 변경됬기때문이다.
    //그러나 내가 임의로 serializationUID를 지정해준다면, 변경된부분만빼고 직렬화가된다. 이렇게 강제로 직렬화 할수있다.


}
