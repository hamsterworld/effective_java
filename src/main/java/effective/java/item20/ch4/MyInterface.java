package effective.java.item20.ch4;

// interface 는
// toString, HashCode , Equals 에대한
// default method 의 overriding 을 막고있다
// 왜막았을까?
// default method 의 핵심은 method 의 추가에 있다.
// interface 에 새롭게 구현할 method 를 추가한다면
// 이거 구현하고 있는 모든 method 가 전부 깨지게된다.
// 즉, 전부 구현해야된다.
// 그래서 method 추가에 편리함에 있어서 default 를 추가한것이다.
// toString, HashCode , Equals 와 같은 Override 처럼
// 설계에 위험함을 끼워넣기 위함이 아니다.(poor man's traits)

// interface 규칙 2가지
// 1. Class 가 interface 를 이겨야한다.
// 2. 더 specific interface 가 이겨야한다.
// 그래서 이와같은경우는 1처럼 class 것을 따라야하는지 interface 를 따라야하는지 혼란이 온다.

public interface MyInterface {

//    default String toString(){
//        return "myString";
//    }
//
//    default int hashCode(){
//        return 10;
//    }
//
//    default boolean equals(Object o){
//        return true;
//    }

}
