package effective.java.item22;

/**
 *  interface 는 타입을 정의하는 용도로만 사용하라.
 *
 *  1. 상수를 정의하는 용도로 인터페이스를 사용하지 말것!
 *   - 클래스 내부에서 사용할 상수는 내부구현에 해당한다.
 *   - 내부 구현을 클래스의 API로 노출하는 행위가 된다.
 *   - 클라이언트에 혼란을 준다.
 *
 *   상수를 어떻게 정의하냐?
 *
 *   특정클래스에 private final field 로 만들어서 쓰거나 (물론 인터페이스에도 가능하나 가능한 피해라.)
 *   열거형
 *   인스턴스화 할수없는 유틸리티 클래스
 */

//아래가 interface 에대한 대표적인 안티패턴
public interface PhysicalConstants {

    static final double AVOGADROS_NUMBER = 6.02;
    static final double BOLTZMANN_CONSTANT = 1.388;
    static final double ELECTRON_MASS = 9.09;

}
