package effective.java.item7.ch1.cache;

import java.util.*;

/**
 * cache 예제이다.
 *
 * 일단 아래 예제에서는 cache 가 쌓이기만하지
 * remove 하는 동작은 전혀없다.
 * 즉, 쌓이기만 한다. => 메모리누수
 *
 * 여기서 해결하기위해 weakHashMap 을 썻는데 얘는 weakReference 를 지닌 key 사용하는 map 이다.
 * 얘의 특징은 key 가 더이상 참조가되지않으면 즉, weakReference 만 지니게되면 그 key 를 지니고있는 value 를 GC 할때 날라간다.
 */
public class PostRepository {

    private Map<CacheKey,Post> cache;

    public PostRepository(){
        this.cache = new HashMap<>();
    }

//    public PostRepository(){
//        this.cache = new WeakHashMap<>();
//    }

    /**
     * 여기서 나중에 왜 Map key 를 Integer 로 쓰지않고 CacheKey 라는 Object 를 따로만들어서
     * 사용했는지는 나중에 알려주겠다.
     */
//    public Post getPostById(Integer id){
//        CacheKey key = new CacheKey(id);
//        if(cache.containsKey(key)){
//            return cache.get(key);
//         } else{
//            Post post = new Post();
//            cache.put(key,post);
//            return post;
//        }
//    }

    public Post getPostById(CacheKey key){
        if(cache.containsKey(key)){
            return cache.get(key);
        } else{
            Post post = new Post();
            cache.put(key,post);
            return post;
        }
    }

    public Map<CacheKey,Post> getCache(){
        return cache;
    }

    public static void main(String[] args) throws InterruptedException {
        PostRepository postRepository = new PostRepository();

//        Integer p1 = 1;
//        postRepository.getPostById(p1);
        // 사실 생각해보면 이미 cacheKey 는 이미 scope 를 벗어나서 사라짐.

        CacheKey cacheKey = new CacheKey(1);
        postRepository.getPostById(cacheKey);
        // 위와 같은경우는 cacheKey 를 계속 지니고있으므로 사라지지않는다.

        cacheKey = null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);
        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());
    }


}
