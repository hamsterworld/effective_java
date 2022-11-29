package effective.java.item7.ch1.cache;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
     * 사용했는지는 나중에 알려주겠다. --> backgroundThread 때 createdate 쓸려고.
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

        //1번
//        Integer p1 = 1;
//        postRepository.getPostById(p1);

        //2번
        CacheKey Key1 = new CacheKey(1);
        postRepository.getPostById(Key1);

        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());
        //메모리를 정리하는 첫번째방법 = 직접 null로 만들어준다.


        //메모리를 정리하는 2번째방법 = 바운더리밖으로 빼버리기

        //만약에 2번처럼 처리하게된다면 어떻게될까?
        //2번처럼하나면 cacheKey 가 여기서는 이 main 매서드가 끝나기전까지 유효하다.
        //그래서 이 Key1이 method 가 끝날때까지 유효하다.
        //이경우에는 아무리 내가 weak reference 를 썻음에도불구하고 Key1이 strong 살아있기때문에 끝나지않는다
        //그러나 Key1을 null 로 주게된다면?
        Key1 = null;
        //바로 true 가 뜨게된다. 사실상 null 을 준건 이 매서드가끝나서 key1이라는것이 끝나버리게된것
        //즉 이렇게 매서드밖으로 나가버린다는것은 null 을 준것이나 마찬가지이다.
        //결국 p1도 굳이 null 을 주지않아도 됫던이유가 바로이것이다.


        //메모리를 정리하는 3번째방법 =
        // 직접 관리하기 cache 에서 제일오래전에 사용햇던걸 빼거나 삭제
        // 대표적으로 LRU cache 같은것들
        // LRU cache 를 한번구현해보는것도 괜찮다.(가창최근에 사용한 10개만 남기는 그런 LRU cache)
        // 그래서 LRU cache 를 사용하면 가장최근에 사용했던 것들 남기도한다.

        //메모리를 정리하는 4번째방법 = 적절한 자료구조를 써서 컨트롤한다.
        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);
        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());
    }

    /**
     * repo instance 가 살아있으면
     * 당연히 cache 도 살아있고
     * cache 가 살아있으면 당연히 Map 도 살아있으므로
     * 안에 ref 들이 살아있는것은 당연하다.
     *
     * weakHashMap 은 strong 하지않으므로 날라간다.
     */
}
