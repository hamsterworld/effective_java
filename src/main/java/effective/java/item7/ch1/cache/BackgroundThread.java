package effective.java.item7.ch1.cache;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackgroundThread {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Background Thread 를 이용한 주기적으로 clean up을 하는것을 실행한다.
         * 이 밑에예제돌릴때 그냥 HashMap 으로 변경!
         */
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        PostRepository postRepository1 = new PostRepository();
        CacheKey Key1 = new CacheKey(1);
        Thread.sleep(1000L);
        CacheKey Key2 = new CacheKey(2);
        Thread.sleep(1000L);
        CacheKey Key3 = new CacheKey(3);
        postRepository1.getPostById(Key1);
        postRepository1.getPostById(Key2);
        postRepository1.getPostById(Key3);

        System.out.println(postRepository1.getCache());

        //이작업이 주기적으로 정리하는 작업이다.
        //이것을 backgroundThread 로 돌리는것이다.
        Runnable removalOldCache = () -> {
            System.out.println("running removeOldCache task");
            Map<CacheKey, Post> cache = postRepository1.getCache();
            Set<CacheKey> cacheKeys = cache.keySet();
            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
            key.ifPresent((k) -> {
                System.out.println(" removing " + k);
                cache.remove(k);
            });
        };

        System.out.println("The Time is : " + new Date());

        //처음에 1초있다가 매3초마다 작업을하도록 시킨다.
        executor.scheduleAtFixedRate(removalOldCache,
                1,3, TimeUnit.SECONDS);

        Thread.sleep(20000L);

    }
}
