package effective.java.item22;

/**
 * 이런 유틸리티클래스에 이렇게 만들수도있다.
 * 이 방법을 권장한다.
 */
public final class PhysicalConstantss {

    private PhysicalConstantss() {
    } // 인스턴스화 방지, 상속방지

    static final double AVOGADROS_NUMBER = 6.02;
    static final double BOLTZMANN_CONSTANT = 1.388;
    static final double ELECTRON_MASS = 9.09;

}
