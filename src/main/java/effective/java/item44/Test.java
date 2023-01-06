package effective.java.item44;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;

public class Test extends LinkedHashMap<String,String>{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Robert C. Martin", "Clean Code");
        map.put("Joshua Bloch", "Effective Java");

        for (String key : map.keySet()) {
            System.out.println("key = " + key + " value = " + map.get(key));
        }

        for (Map.Entry<String, String> book: map.entrySet()) {
            System.out.println("key = " + book.getKey() + " value = " + book.getValue());
        }

        Test test = new Test();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            boolean b = test.removeEldestEntry(entry);
            BiPredicate<Map<String, String>,Map.Entry<String, String>> biPredicate = (m,e) -> m.size() > 100;
//            new LinkedHashMap<>(biPredicate);
            //LinkedHashMapFactory(biPredicate);
           System.out.println(b);
        }


    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
