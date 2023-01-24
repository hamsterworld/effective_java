package effective.java.item7.ch3.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


/**
 * 여기서 왜 Map key 를 Integer 로 쓰지않고 CacheKey 라는 Object 를 따로만들었는지 알려주겠다.
 */
public class PostRepository {

//    private Map<CacheKey, Post> cache;
    private Map<Integer, Post> cache;

//    public PostRepository(){
//        this.cache = new HashMap<>();
//    }

    public PostRepository(){
        this.cache = new WeakHashMap<>();
    }

//    public Post getPostById(CacheKey key){
//        if(cache.containsKey(key)){
//            return cache.get(key);
//        } else{
//            Post post = new Post();
//            cache.put(key,post);
//            return post;
//        }
//    }

    public Post getPostById(Integer key){
        if(cache.containsKey(key)){
            return cache.get(key);
        } else{
            Post post = new Post();
            cache.put(key,post);
            return post;
        }
    }

//    public Map<CacheKey, Post> getCache(){
//        return cache;
//    }

    public Map<Integer, Post> getCache(){
        return cache;
    }

    // 여기서는 Integer 와 cacheKey 로 했을때의 차이를 보자
    public static void main(String[] args) throws InterruptedException {
        PostRepository postRepository = new PostRepository();

        Integer p1 = 1;
        postRepository.getPostById(p1);
        p1 = null;

//        CacheKey cacheKey = new CacheKey(1);
//        postRepository.getPostById(cacheKey);
//        cacheKey = null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);
        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());
    }

    // key 가 Integer 로 변경후 p1 = null 로 해도 weakHashMap 으로해도 사라지지않는다.
    // 어딘가에 래퍼런스가 살아있다는 말이다.
    // 그래서 weakHashMap 을쓸때 주의해야한다. 위에처럼 래퍼런스를 따로 만들어서해야한다.
    // Integer 와 같은 래퍼타입은 어디간에 캐쉬되있어서 사라지지않는다.

}
