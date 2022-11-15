package effective.java.item1.InterfaceandstaticMethod.extra;

@java.lang.FunctionalInterface
public interface FunctionalInterface<T> {

    T Test();

    //T Test2(); 추상매서드가 2개이상일수없다.

    default ProcessFile test2(){
        ProcessFile processFile = new ProcessFile();
        System.out.println("default");
        return processFile;
    }

    static void test3(){
        System.out.println("static");
        test4();
    }

    private static void test4(){
        System.out.println("private static");
    }




}
