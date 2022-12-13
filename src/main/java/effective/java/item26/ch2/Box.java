package effective.java.item26.ch2;

//<E extends Number>
public class Box<E> {

    private E item;

    private void add (E e){
        this.item = e;
    }

    private E get(){
        return this.item;
    }

    public static void main(String[] args) {
//        Box box = new Box<>();
//        box.add(1);
//        System.out.println(box.get() * 100);

        Box<Integer> box = new Box<>();
        box.add(1);
        System.out.println(box.get() * 100);
        // byteCode 를 보면 원래는 Object 인데 컴파일할때 java 가 알아서 캐스팅을 해주는것이다.

        printBox(box);
    }

    private static void printBox(Box<?> box){
        System.out.println(box.get());
    }


}
