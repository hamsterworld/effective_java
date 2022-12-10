package effective.java.item8.ch2;

import java.lang.reflect.Field;

/**
 * 1. static 이 아닌 중첩클래스는 자동으로 바깥객체의 참조를 갖는다.
 * Runnable 을 구현할때 정리하려는 객체안에다가 넣는데 static class 로 한다.
 * 그래서 1번의 말이 무슨말인지 알기위해서 설명하는 class
 */
public class OuterClass {

    private void hi(){

    }

    //정적이 아닌 class다.
    class InnerClass{
        // outerClass 에대한 참조를 innerclass 가 가지고있기때문에 가능하다.
        // field type: class effective.java.item8.ch2.OuterClass
        // field name: this$0 에서 증명하였다 아래 printFiled
        // 당연히 field 도 접근할수있다.

        /**
         * 즉, static 이아닌 그냥중첩클래스는 outerClass 에대한 참조가생기기때문에
         * 우리들이 cleaner 를 등록할때 반드시 static 으로 하라는이유다.
         * 왜냐면 중첩참조가생기지않으므로
         * outer 가 inner 참조하고 inner 는 outer 를 참조하게된다.
         * 이렇게되면 정리가 안되겟지?
         * 결국 순환참조 된다.
         */
        public void hello(){
            OuterClass.this.hi();
        }
    }

    //참고로 람다랑은 달라서 얘는 outer 꺼 참조안해도 this 를 가지고 있다.

    public static void main(String[] args) {
        //정적이 아닌 class 이므로, outerClass 를 먼저만든다음에 가질수있다.
        //그래서 중첩클래스인 inner class 는 굉장히 outer class 에 종속적이다.
        //왜냐? outerClass 안에서만 만들수있거나, outerClass 의 인스턴스가 나온다음에야 나올수있다.
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
