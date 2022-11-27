package effective.java.item13.clone_use_constructor;


public class SubItem extends Item implements Cloneable {

    private String name;

    @Override
    public SubItem clone() {
        // 형변환불가
        return (SubItem)super.clone();
    }

    //clone을 위에처럼 오버라이딩안하고해도
    //암묵적으로 구현된 clone에의해서 또 형변환이 발생하게된다.

    //그래서 super.clone을 어디서 호출하는지에따라서 뭐가 나올지 달라진다.


    public static void main(String[] args) {
        SubItem subItem = new SubItem();
        //하위타입은 상위타입으로 형변환이 가능한데
        //상위타입은 하위타입으로 형변환이 불가능하다.
        SubItem clone = subItem.clone();

        System.out.println(clone != subItem);
        System.out.println(clone.getClass() == subItem.getClass());
        System.out.println(clone.equals(subItem));
    }

}
