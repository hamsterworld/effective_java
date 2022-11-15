package effective.java.item2.ch3.innerclass;

public class Outer {

    private String name;
    private Integer age;
    private String description;

    public void testMethod(){

    }

    public class Inner {
        void innerTestMethod(){
            Outer.this.testMethod();
        }

    }

    public static class staticInner{

        void staticInnerTestMethod(){
            //Outer.this.testMethod(); --> 컴파일 에러
        }
        staticInner(String name){
            String name1 = name;
        }
    }

}
