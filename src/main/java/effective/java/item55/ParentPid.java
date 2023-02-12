package effective.java.item55;

import java.util.Optional;

// 불필요하게 사용한 Optional 의 isPresent 메서드를 제거하자. (329쪽)
public class ParentPid {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        // isPresent를 적절치 못하게 사용했다.
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("부모 PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // 같은 기능을 Optional의 map를 이용해 개선한 코드
//        Optional<String> s = ph.parent().map(h -> String.valueOf(h.pid()));
        System.out.println("부모 PID: " +
            ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }


    // OptionalInt,OptionalLong,OptionalDouble 이 있으니
    // 박싱된기본타입을 담은 Optional 을 반환하지말자.
    // 덜중요한 기본타입인 Boolean,Byte,Character,Short,Float 를 예외일수있다.

    // Optional 을 Collection 의 key,value,element 로 사용하는 것은 적절하지않다.
}
