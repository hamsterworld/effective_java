package effective.java.item2.ch10;

import java.util.Arrays;

public class VarargsSamples {

    public void printNumbers(int... numbers){
        System.out.println(numbers.getClass().getCanonicalName());
        System.out.println(numbers.getClass().getComponentType());
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void main(String[] args) {
        VarargsSamples varargsSamples = new VarargsSamples();
        varargsSamples.printNumbers(5,10);
        varargsSamples.printNumbers(5,10,20,30,40);
    }


    /**
     * 가변인수는 오로지 하나만 사용가능하다. 그리고 맨뒤에 놔야한다.
     *
     *
     *
     */
}
