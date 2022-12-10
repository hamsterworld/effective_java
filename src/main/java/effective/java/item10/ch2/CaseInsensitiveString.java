package effective.java.item10.ch2;

import java.util.Objects;

/**
 * equals 의 규약을 지키면서 작성해라!
 * 1.반사성 A.equals(A) == true
 * 2.대칭성 A.equals(B) == B.equals(A) true= true ,false == false
 */
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //대칭성 위배!(test)
//    @Override
//    public boolean equals(Object o){
//
//        if(o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(
//                    ((CaseInsensitiveString) o).s);
//        }
//        if(o instanceof String){ //한 방향으로만 작동한다. 마치이말은 자기가 String 과 동급으로 쓰겟다는 말이다.
//            return s.equalsIgnoreCase((String) o);
//        }
//
//        return false;
//    }

    //수정한 equals 메서드 (test2)
    //같은 타입끼리 비교해라.
    @Override
    public boolean equals(Object o){

        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    //즉 다른타입을 지원하면안된다.
    //다른 타입을 지원하니까 대칭성이 깨져버린것이다.

}
