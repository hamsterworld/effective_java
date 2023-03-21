package effective.java.item80;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 태스크를 여러 번 실행
        for (int i = 0; i < 500; i++) {
            executorService.submit(() -> {
                System.out.println("Hello from SimpleTask: " + Thread.currentThread().getName());
            });
        }

        // 태스크를 여러 번 실행
        for (int i = 0; i < 500; i++) {
            executorService.submit(() -> {
                System.out.println("Hello from SimpleTask: " + Thread.currentThread().getName());
            }).get(); // 여기서 get 은 하나의 작업이 끝날때까지 기다린다.
        }

        // 실행자 서비스를 종료
        executorService.shutdown();
    }
}
