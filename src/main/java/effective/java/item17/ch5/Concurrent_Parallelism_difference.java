package effective.java.item17.ch5;

import java.util.concurrent.CountDownLatch;

/**
 * Concurrent 는
 * cpu 하나가
 * 마치 여러가지의 일을 하는것처럼 보이지만 실제로는 하나의 작업만 하는것이
 * Concurrent 병행이다.
 *
 * Parallelism 은
 * 실제로 나란히 동시에 구동
 * multi core cpu 인 애들이 가능하다.
 * 그래서 cpu 가 여러개 동시에 하는것.
 *
 * 자바는 그래서
 * cpu 를 쓸때 모든 코어에서 쓰레드를 사용하여
 * 병행이면서 동시에 병렬적으로 사용한다.
 *
 * 병행이든 병렬이든 쓰레드를 잘 사용하면된다.
 * 그래서 concurrent package 를 잘사용해보자
 * 오늘은 countDownLatch 를 알아보자.
 */
public class Concurrent_Parallelism_difference {
    public static void main(String[] args) throws InterruptedException {

        int N = 10;
        CountDownLatch startSignal = new CountDownLatch(1); //딱 한번만 센다.
        CountDownLatch doneSignal = new CountDownLatch(N); //0이 되면 끝난다. 애네는 재사용이 안된다 일회용

        for (int i = 0; i< N; ++i){
            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        ready();
        startSignal.countDown();
        doneSignal.await();
        done();
    }

    private static void done() {
        System.out.println("끝!");
    }

    private static void ready() {
        System.out.println("준비~~~~");
    }

    private static class Worker implements Runnable{
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try{
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void doWork() {
            System.out.println("working thread : " + Thread.currentThread().getName());
        }
    }
}
