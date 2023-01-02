package effective.java.item26.ch1;

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
        // 아래처럼 제내릭이 매개변수화 되있으므로 매개변수화 타입이라고도한다.
        Box<Integer> box = new Box<>();
        // 한정적 제네릭 타입에 의해서 제한되었다.
        box.add(0);
        Box.printBox(box);

        Box<String> box1 = new Box();
        box1.add("hihi");
        Box.printBox(box1);

        // 타입을 선언하는쪽에서 ? 를 선언할수있다.
        // ? = 비한정적 와일드카드
        // ? extends , ? super 가 없는경우 비한정적 와일드카드라고한다.
        // 즉, 아무타입이나 의미한다.
        // ? extends , ? super 있으면 한정지을수있다.
        // 와일드카드는 아래처럼 쓰는건 아니고 printBox 와같은 매개변수때 보통사용하는듯?
//        Box<?> box2 = new Box<>();
        Box<? extends Number> box3 = new Box<>();
//        box3 = box;
//
//        box3.add(1);

        Class<? extends Box> aClass = box.getClass();
    }

    // 비한정적 와일드카드를 쓰고있다 즉, 아무런 type 이 와도 상관없다는것이다.
    // 그래서 printBox(Box box) 이것도 상관없다. 그러나 Box<?> 이게더 안전한 코드이다.
    private static void printBox(Box<?> box){
        System.out.println(box.get());
    }

//    private static void printBox(Box<String> box){
//        System.out.println(box.get());
//    }

    // 제네릭은 변하지않는다.
    // Box<Integer> 받을수없다.
    // 받을려면 Box<? extends Object> 가되야한다.
//    private static void printBox(Box<Object> box){
//        System.out.println(box.get());
//    }

    // 아래는 한정적 와일드카드
    // 임의의 Object 인데 Number 를 상속한 애들만 가능하다는것이다.
    // 사실 <?> = <? extends Object> 이다.
    private static void printBox1(Box<? extends Number> box){
        System.out.println(box.get());
    }

}
