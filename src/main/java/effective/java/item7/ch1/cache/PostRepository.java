package effective.java.item7.ch1.cache;

import java.util.*;

public class PostRepository {

    private Map<CacheKey,Post> cache;

//    public PostRepository(){
//        this.cache = new HashMap<>();
//    }

    public PostRepository(){
        this.cache = new WeakHashMap<>();
    }

    /**
     * 여기서 나중에 왜 Map key 를 Integer 로 쓰지않고 CacheKey 라는 Object 를 따로만들어서
     * 사용했는지는 나중에 알려주겠다. --> backgroundThread 때 createDate 쓸려고.
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
        //Integer p1 = 1;
        //postRepository.getPostById(p1);

        //2번
        CacheKey Key1 = new CacheKey(1);
        postRepository.getPostById(Key1);
        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());

        //메모리를 정리하는 2번째방법 = 바운더리밖으로 빼버리기
        Key1 = null;

        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);
        System.out.println("비여있나요? " + postRepository.getCache().isEmpty());
    }


}
