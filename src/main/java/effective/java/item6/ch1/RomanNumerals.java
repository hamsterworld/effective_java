package effective.java.item6.ch1;

import java.util.regex.Pattern;

//값비싼 객체를 재사용해서 성능을 개선한다.
public class RomanNumerals {

    // 코드 6-1 성능을 더 높일수있다.
    static boolean isRomanNumeralSlow(String s){
        return s.matches("regex");
    }

    // 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
    private static final Pattern ROMAN = Pattern.compile(
            "regex"
    );

    static boolean isRomanNumeralFast(String s){
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {

        boolean result = false;
        long start = System.nanoTime();

        for (int j = 0; j < Integer.MAX_VALUE; j++ ){
            // 성능 차이를 확인하려면 xxSlow 매서드에서 xxFast 매서드로 변경해보자
            result = isRomanNumeralSlow("THERGERG");
        }

        long end = System.nanoTime();

        System.out.println(end - start);
        System.out.println(result);
    }




}
