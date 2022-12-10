package effective.java.item7.ch3.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository(){
        this.cache = new WeakHashMap<>();
    }

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

    public Map<CacheKey, Post> getCache(){
        return cache;
    }

}
