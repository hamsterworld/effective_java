package effective.java.item26.ch2;

public class UseRawType<E> {
    private E e;

    public static void main(String[] args) {
        System.out.println(UseRawType.class);
        //System.out.println(UseRawType<String>.class);  이런 Class 는 존재하지않는다.


        UseRawType<String> stringType = new UseRawType<>();

        System.out.println(stringType instanceof UseRawType);
    }

}
