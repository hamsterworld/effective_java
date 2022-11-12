package effective.java.item8.ch2;

import java.lang.reflect.Field;

/**
 * 1. static이 아닌 중첩클래스는 자동으로 바깥객체의 참조를 갖는다.
 * Runable을 구현할때 정리하려는 객체안에다가 넣는데 static class로 한다.
 * 그래서 1번의 말이 무슨말인지 알기위해서 설명하는 class
 */
public class OuterClass {

    private void hi(){

    }

    //정적이 아닌 class다.
    class InnerClass{
        // outerclass에대한 참조를 innerclass가 가지고있기때문에 가능하다.
        // field type: class effective.java.item8.ch2.OuterClass
        // field name: this$0 에서 증명하였다 아래 printFiled
        // 당연히 field도 접근할수있다.

        /**
         * 즉, static이아닌 그냥중첩클래스는 outerclass에대한 참조가생기기때문에
         * 우리들이 cleaner를 등록할때 반드시 static으로 하라는이유다.
         * 왜냐면 중첩참조가생기지않으므로
         * outer가 inner 참조하고 inner는 outer를 참조하게된다.
         * 이렇게되면 정리가 안되겟지?
         * 결국 순환참조 된다.
         */
        public void hello(){
            OuterClass.this.hi();
        }
    }

    //참고로 람다랑은 달라서 얘는 outer꺼 참조안해도 this를 가지고 있다.

    public static void main(String[] args) {
        //정적이 아닌 class이므로, outerclass를 먼저만든다음에 가질수있다.
        //그래서 중첩클래스인 inner class는 굉장히 outer class에 종속적이다.
        //왜냐? outerclass 안에서만 만들수있거나, outerclass의 인스턴스가 나온다음에야 나올수있다.
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(innerClass);

        outerClass.printFiled();
    }

    private void printFiled(){
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type: " + field.getType());
            System.out.println("field name: " + field.getName());
        }
    }

}
