package effective.java.item6.ch4;

import java.util.regex.Pattern;

/**
 * 정규식을 공부하기보다는, Java에서 정규식이 어디에 쓰이는가를 중점적으로..
 */
public class RegularExpression {

    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");
    private static final Pattern SPLIT_PATTERN3 = Pattern.compile(",,,");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for(int j = 0; j<10000; j++){
            String name = "keesun,whiteship";
            name.split(","); //한두개정도는 미리 complie하는거랑은 크게차이가없다.
            SPLIT_PATTERN.matcher(name).matches();
            /**
             * matche,split,replaceall,replacefirst
             * 아마 arg에 regex잇는거면 의심해볼만한듯듯
             * */
//            String name3 = "keesun,,,,whiteship";
//            name3.split(",,,"); //이런경우는 이야기가달라진다.
//            SPLIT_PATTERN3.matcher(name).matches();
        }
        System.out.println(System.nanoTime() - start);
    }

}
