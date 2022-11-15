package effective.java.mypractice.flyweight;

import effective.java.item1.Flyweight.Font;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private static Map<String, Item> cache = new HashMap<>();

    public static Item factory(String name){
        if(cache.containsKey(name)){
            System.out.println("캐쉬된거에서 찾기");
            return cache.get(name);
        } else {
            System.out.println("캐쉬된게 없어서 새로 만들고 저장");
            Item item = new Item(name);
            cache.put(name,item);
            return item;
        }

    }

}
