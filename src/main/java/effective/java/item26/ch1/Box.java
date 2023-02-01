package effective.java.item26.ch1;

// <E extends Number>
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
//        Box.printBox(box1);

        // 타입을 선언하는쪽에서 ? 를 선언할수있다. => 타입
        // ? = 비한정적 와일드카드
        // ? extends , ? super 가 없는경우 비한정적 와일드카드라고한다.
        // 즉, 아무타입이나 의미한다.
        // ? extends , ? super 있으면 한정지을수있다.
        // 와일드카드는 아래처럼 쓰는건 아니고 printBox 와같은 매개변수때 보통사용하는듯?
//        Box<?> box2 = new Box<>();
        Box<? extends Number> box3 = new Box<>();

        box3 = box;
//        box = box3;
//
//        box3.add(1);

        Class<? extends Box> aClass = box.getClass();
        Box.printBox1(box);
    }

    // 비한정적 와일드카드를 쓰고있다 즉, 아무런 type 이 와도 상관없다는것이다.
    // 그래서 printBox(Box box) 이것도 상관없다. 그러나 Box<?> 이게더 안전한 코드이다.
//    private static void printBox(Box<?> box){
//        System.out.println(box.get());
//    }

    private static <T extends Number> void printBox(Box<T> box){
        System.out.println(box.get());
//        T item1 = box.item; // 우리는 이 T 가 어쨋든 Number 거나 그에 하위타입이 올거라는것을 우린 안다.
        // 그러므로 얘도 add 할 수없다.
        // 뭘넣거나 하는건 한정적타입밖에 안된다. 그것으로 정해져있으므로.
//        box.add(30);
    }
    private static void hamster(Box<? extends Number> box){
        Number item1 = box.item; // Box 에 뭐가올지모르지만 Number 거나 그의 하위타입이란것은 보장할수있다.
        Number item2 = box.item; // => box.item 의 타입을 보면 capture of ? extends Number
        Integer item3 = (Integer) box.item; // 이런식으로 casting 가능
//        box.item = 10; 한정적타입인 Box<Number>라면 넣을수있다.
        // 왜냐면 무조건 Number 가 오기때문이다
        // 즉, 박스 내부의 E 는 Number 타입이라고 지정이 되버린다.

        // 그러나 비한정적타입은 E 가 Number 가될지 그밑에 하위타입이 될지 모른다.
        // 확실한것은 E 자체가 Number 거나 하위클래스가 올거라는 사실만은 안다.
        // 그러므로, box 에 함부로 무엇인가를 넣을수없다.

        // 헷갈리기쉬운게 E 가 Number 여서 box 에 Number 하위타입도 받을수있는것과
        // E 가 Number 이거나 하위타입일수 있다는 사실이라는것은
        // 전혀 다른것이다.
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
