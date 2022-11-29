package effective.java.item7.ch4;

import java.util.concurrent.*;

public class ExecutorsExample2 {

    public static void main(String[] args) throws ExecutionException,InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<String> submit = service.submit(new Task()); //blocking 되지 않는다.
        //call 작업때메 기다리지않는다.

        System.out.println(Thread.currentThread() + " hello");

        System.out.println(submit.get()); //get 은 blocking call 이다.
        // 무슨 말이냐면 return 을 받기위해서 call method 작업을 기다린다는것이다.


        service.shutdown();

        // threadPool 종류와 내부자료구조 공부.
        // 또 ExecutorService 의 여러 Operation 에대해서도 공부해볼것.
        // 그다음 completableFuture 에 대해서 공부해볼것
        // 위 순서대로 공부해볼것 요망
        // completableFuture 가 내부적으로 사용하는 porkandpool 이있는데 여기까지 가려면 공부를 많이 해야한다.
    }

    //Callable 은 return type 이 있다.
    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            try {
                System.out.println(Thread.currentThread() + "hihi");
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Thread.currentThread()+ " world";
        }
    }
}
