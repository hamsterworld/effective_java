package effective.java.item3.ch3;

public class MetaElvis<T> {

    private static final MetaElvis<Object> Instance = new MetaElvis<>();

    private MetaElvis(){

    }

    @SuppressWarnings("unchecked")
    public static <T> MetaElvis<T> getInstance() {
        return (MetaElvis<T>) Instance;
    }

    public void say(T t){
        System.out.println(t);
    }

    public void leaveTheBuilding(){
        System.out.println("Whoa baby, I'm outta here!!");
    }

    public static void main(String[] args) {
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();

        //System.out.println(elvis1 == elvis2);
        //타입이 달라서 ==비교는 안된다.
        //같은 객체임에도 불구하고 안된다. 타입이 달라서.

        /**
         *  인스턴스는 동일하지만.
         *  각각에 원하는 타입으로 바꿔서 사용할수가있다.
         *  이것이바로 제네릭팩토리를 사용하면 얻을수있는 장점이다.
         *  제네픽팩토리가 하는일은 단순히 원하는 제네릭타입으로 변경만 시켜준다.
         */


        /**
         * <T> MetaElvis<T> 이 왜 한번더 <T>가들어가는지 설명할줄알아야한다.
         * class에서의 <T>와 scope이 다르다.
         * 그래서
         *    public static <E> MetaElvis<E> getInstance() {
         *         return (MetaElvis<E>) Instance;
         *     } 해도 정상적으로 작동한다.
         * 그러나
         *      public void say(T t){
         *         System.out.println(t);
         *     } 는 class의 <T>가 맞다.
         *
         */
    }

}
