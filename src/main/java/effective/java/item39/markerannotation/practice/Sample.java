package effective.java.item39.markerannotation.practice;

public class Sample {

    @Test
    public static void sample1(){

    }

    public static void sample2(){

    }

    @Test // 잘못사용 정적매서드가 아니다.
    public void sample3(){

    }

    @Test // 실패해야한다.
    public static void sample4(){
        throw new IllegalArgumentException();
    }

    @Test
    public void sample5(){
        throw new RuntimeException("실패입니다.");
    }



}
