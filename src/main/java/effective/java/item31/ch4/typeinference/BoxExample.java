package effective.java.item31.ch4.typeinference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {

    private static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    private static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    private static void processStringList(List<String> stringList) {

    }


    public static void main(String[] args) {
        // 타입추론이란 자바 컴파일러가 우리가 명시하지않아도 뭘쓸지를 알아내는것이다.
        // 아래처럼
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();

        // 아래처럼 return type을 이렇게 알려줄수있다. 그러나 추론이 가능하다.
        BoxExample.<Integer>addBox(10, listOfIntegerBoxes);
        BoxExample.addBox(20, listOfIntegerBoxes);
        BoxExample.addBox(30, listOfIntegerBoxes);
        BoxExample.outputBoxes(listOfIntegerBoxes);

        // Target Type 을 보고 추론을 할수있다.
        List<String> stringlist = Collections.emptyList();
        List<Integer> integerlist = Collections.emptyList();

        // 아래처럼 굳이안줘도 return Target Type 으로 추론될수있는것이다.
        BoxExample.processStringList(Collections.<String>emptyList());

        /**
         * 그냥 이런게 있다정도만 알아두자.
         */
    }
}
