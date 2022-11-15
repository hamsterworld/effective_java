package effective.java.item1.InterfaceandstaticMethod.extra;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
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
                return "익명클래스는 이러고 끝이다.";
            }
        });

        Supplier<String> supplier = () -> {
            if("hi".equals("hi")){
                return "hi";
            }
            return "no hi";
        };

        System.out.println(supplier.get());


        //익명클래스를 매개변수로 받을때
        ProcessFile processFile = new ProcessFile();
        processFile.processfile( b ->  {
            if("hi" == "hi"){
                return "hihi";
            }
                return null;
        } );

        //인스턴스 불가화
        //얻은 구현체는 interface로..
        //결국 얻은 구현체는 interface대로 동작하기때문에.
        //굳이 따로 사용법을 알필요가없다.
        //요리사 interface를 얻엇으면 sheff.cook(); 알지만
        //hambergersheff.hambegercook(); 인지뭔지 일단 익혀야할지도모른다.
        //그리고 API를 작게만드는 경향도 있어서 매우좋다.
//        Queue<Object> objects = Collections.asLifoQueue();
//        List<Object> objects1 = Collections.checkedList();

    }
}
