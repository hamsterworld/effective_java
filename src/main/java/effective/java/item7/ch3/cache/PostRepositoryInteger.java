package effective.java.item7.ch3.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepositoryInteger {

    private Map<Integer, Post> cache;

    public PostRepositoryInteger(){
        this.cache = new WeakHashMap<>();
    }

    /**
     * 여기서 나중에 왜 Map key를 Integer로 쓰지않고 CacheKey라는 Object를 따로만들어서
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

    public Post getPostById(Integer key){
        if(cache.containsKey(key)){
            return cache.get(key);
        } else{
            Post post = new Post();
            cache.put(key,post);
            return post;
        }
    }

    public Map<Integer, Post> getCache(){
        return cache;
    }

}
