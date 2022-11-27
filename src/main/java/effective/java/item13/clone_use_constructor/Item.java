package effective.java.item13.clone_use_constructor;

public class Item implements Cloneable {

    private String name;

    /**
     * 만약에 생성자를 생성해서 clone 을 사용하는경우 어떻게될까?
     *
     * 이러면 규약이 깨진다.
     */
//    @Override
//    public Item clone() {
//        Item item = new Item();
//        item.name = this.name;
//        return item;
//    }

    @Override
    public Item clone(){
        Item clone = null;
        try {
            clone = (Item)super.clone();
        } catch (CloneNotSupportedException e) {
            throw  new AssertionError();
        }
        return clone;
    }
}
