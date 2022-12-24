package effective.java.item26.ch2;

public class UseRawType<E> {
    private E e;

    // Class 는 아래처럼 Generic 으로 같이쓸수없기에.
    // 이부분은 예외로 적용된다.
    public static void main(String[] args) {
        System.out.println(UseRawType.class);
        //System.out.println(UseRawType<String>.class);  이런 Class 는 존재하지않는다.

        UseRawType<String> stringType = new UseRawType<>();
    // instance 도 마찬가지이다. 컴파일은 되지만 코드를 장황하게 만든다.
        System.out.println(stringType instanceof UseRawType);
    }

    /**
     * 결론 Class 와 instanceof 를 쓸때를 제외하고는
     * Generic 을 사용해주자. 꼭!
     */
}
