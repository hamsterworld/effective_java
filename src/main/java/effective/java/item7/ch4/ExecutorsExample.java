package effective.java.item7.ch4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException,InterruptedException {

        //만약에 우리가 쓰레드 100개를 만들어서 실행해야된다?
        //우리는 너무많은 리소스를 낭비하게된다.
        //쓰레드를 만드는건 리소스가 굉장히 낭비된다.

        //그러면 이러한 작업을 쓰레드 100개 안만들어도 100개의작업을 비동기적으로 할수있다면?
        //그게 바로 쓰레드풀이다.
//        for(int i = 0; i<100; i++){
//            Thread thread = new Thread(new Task());
//            thread.start();
//        }

        //10개를 만들어놓고 10개를 돌려쓰면서 100개의 작업을 수행한다.
        //당연히 속도는 조금 느리겟지만 아까보단 효율적이다.
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i =0; i<100; i++){
            service.submit(new Task());
        }

        // Java - ConcurrentModificationException 찾아볼것
        // 일반적인 arrayList 나 hashMap 은 concurrent 에 안전한 collection 이 아니다.
        // 동시다발 적으로 동일한 collection 을 조작하면 ConcurrentModificationException 가 발생할수있다.
        // 그래서 concurrency 를 지원하는 즉 collection 에서 이런 조작을 가해도문제가없는 queue 가 있다.
        // blocking queue 를 사용한다
        // newFixedThreadPool 같은경우 그 큐를 사용한다.

        // newCachedThreadPool 은 thread 가 무한정 늘어나고 자원이 낭비될수있다.
        ExecutorService service1 = Executors.newCachedThreadPool();

        //newSingleThreadExecutor 는 Thread 1개로 전부다 처리한다.

        //newScheduledThreadPool 는 작업을 몇초마다 한번씩 실행해라 같이 스케줄을 맥여서 실행시킬수있다.
        service.shutdown();


        // 적절한 threadPool 개수를 정해야할때 흔히 2가지를 고려한다.
        // cpu 에 집중적인지? , i/o 에 집중적인지?
        // cpu intensive 한 작업은 cpu 갯수만큼만 만들게될것이다.
        // 어차피 cpu 보다 많아봣자 놀고잇을테니
        int cpuNumbers = Runtime.getRuntime().availableProcessors();
        ExecutorService cpuIntensiveService = Executors.newFixedThreadPool(cpuNumbers);

        // i/o intensive 한 작업을 한다면?
        // db 에서 데이터를 가져온다던가 network 에서 http 를 call 해서 값을 가져온다던지
        // 그때 i/o 에의해서 blocking 이 된다면 input, output 처리때메 delay 가 될것이다.
        // cpu 개수 4개만큼 정햇다치자. 그이미 i/o 때메 4개가 기다리는데
        // cpu 리소스는 남아돈다. i/o 때메 일을 안함.
        // 기본적으로 쓰레드를 좀더 받아도된다 이럴때는.
        // 그개수를 적절하게 정하는것을 그래서 연구한다.
        // 그래서 성능 튜닝을 하는것이다. 그래서 i/o 는 좀더 많은 쓰레드를 필요로한다.
        System.out.println(Thread.currentThread() + " hello");
    }


    //Runnable 은 return type 이 없다.
    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread()+ " world");
        }
    }

}
