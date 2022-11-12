package effective.java.item7.ch3;

import effective.java.item7.ch3.cache.CacheKey;
import effective.java.item7.ch3.cache.PostRepository;
import effective.java.item7.ch3.cache.PostRepositoryInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PostRepositoryTest {

    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        CacheKey cacheKey = new CacheKey(1);
        /**
         * 이것을 굳이 Reference로 만들어준 이유는 무엇일까?
         *  Integer,기본타입,String은 JVM내부에서
         *  일부값들이 캐시가된다.
         *  그래서 내가 null만들어도, strong reference가 남아있다고 생각하고 지워지지가 않는다.
         */
        postRepository.getPostById(cacheKey);

        Assertions.assertFalse(postRepository.getCache().isEmpty());

        cacheKey=null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        Assertions.assertTrue(postRepository.getCache().isEmpty());
    }

    @Test

    void cache2() throws InterruptedException {
        PostRepositoryInteger postRepository = new PostRepositoryInteger();
        Integer p1 = 1;

        /**
         *  이것을 굳이 Reference로 만들어준 이유는 무엇일까?
         *  Integer,String은 JVM내부에서
         *  일부값들이 캐시가된다.
         *  그래서 내가 null만들어도, strong reference가 남아있다고 생각하고 지워지지가 않는다.
         */
        postRepository.getPostById(p1);

        Assertions.assertFalse(postRepository.getCache().isEmpty());

        p1=null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        /**
         * 이미 JVM내부에 cache가 되어있어서. 결국 삭제되지않게된다.
         */
        Assertions.assertFalse(postRepository.getCache().isEmpty());
    }
}
