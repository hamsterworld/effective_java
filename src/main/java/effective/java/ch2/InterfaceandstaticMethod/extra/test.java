package effective.java.ch2.InterfaceandstaticMethod.extra;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {

    public static void main(String[] args) throws Exception {

        FunctionalInterface<String> functionalInterface = () -> "Hello java";
        String test = functionalInterface.Test();
        System.out.println(test);
        functionalInterface.test2();
        FunctionalInterface.test3();



        FunctionalInterface<String> functionalInterface1 = new FunctionalInterface<>() {
            @Override
            public String Test() {
                return "Hello java";
            }
        };
        functionalInterface1.Test();


        //익명클래스 이러고 끝이다.
        System.out.println(new FunctionalInterface<>() {
            @Override
            public String Test() {
                return "Hello java";
            }
        });

        Supplier<String> supplier = () -> {
            if("hi".equals("hi")){
                return "hi";
            }
            return "no hi";
        };



        //익명클래스를 매개변수로 받을때
        ProcessFile processFile = new ProcessFile();
        processFile.processfile( b ->  {
            if("hi" == "hi"){
                return "hihi";
            }
                return null;
        } );

    }
}
