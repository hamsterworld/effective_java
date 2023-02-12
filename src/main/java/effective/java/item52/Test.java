package effective.java.item52;

import java.io.ObjectOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private String test1;
    private int test2;
    private String test3;

    public Test(String test1) {
        this.test1 = test1;
    }

    public Test(int test2) {
        this.test2 = test2;
    }


    public static void main(String[] args) {
        new Thread(System.out::println).start();
//        Runnable r
//        Callable<String>
        ExecutorService exec = Executors.newCachedThreadPool();
        // 컴파일 에러가 난다.
//        exec.submit(System.out::println);


    }
}
