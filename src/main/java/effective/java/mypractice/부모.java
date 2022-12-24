package effective.java.mypractice;

public class 부모<E,V> {

    private E name;

    private V[] elements;

    void method(){
        System.out.println("부모");
    }

    void setElements(){
        Object[] objects = new Object[10];
        objects[0] = 1;
        objects[1] = "haha";
        // 사실상  V[] 는 소거된다고 보고 이렇게 cast 하라라고만 하는거네.
        this.elements = (V[]) objects;
    }

    V getElements(){
        return this.elements[0];
    }

    void cast(Object o){
        자식 자식 = (자식)o;
        자식.method1();
    }

    public E getName() {
        return name;
    }

    public static void main(String[] args) {

//        자식 자식1 = new 자식();
//        부모 부모1 = 자식1;
//        System.out.println("====");
//        부모1.method();
//        자식1.method();
//        System.out.println("====");
//        부모1.cast(new 자식());
//        부모1.cast(new Object());

        // upCasting 된것을 downCasting 할순있지만.
        /**
         * 이게 핵심이다.
         * downCasting 은 애초에 그자체를 downCasting 은 불가능하다.
         * upCasting 해놧던걸 downCasting 은 가능하다.
         */
//        부모 부모 = new 자식();
//        자식 자식 = (자식) 부모;
//
//        부모.method();
//        ((자식) 부모).method1();
//        자식.method1();
//
//        자식.method1();
//        자식.method();

        // 애초에 부모 자체를 downCasting 할수없다.
        부모 부모1 = new 부모();
//        자식 자식1 = (자식) 부모1;
        부모1.method();
//        자식1.method1();
//        자식1.method();

//        부모<String> 부모2 = new 부모<>();
//        부모2.name = "hihi";
//        부모2.name = 1;

//        Object name1 = 부모2.name;
//        String name2 = (String) name1;
//        System.out.println(name1);

//        Object o = new Object();
//        String name3 = (String) o;

//        System.out.println(부모2.getName());
//        System.out.println(부모2.name);

        /**
         * 이게 바로 문제다.
         */
//        부모<Integer, String> objectObject부모 = new 부모<>();
//        objectObject부모.setElements();
//        String elements1 = objectObject부모.getElements();
    }
}
